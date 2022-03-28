package ningenme.net.sample.common.config;

import lombok.RequiredArgsConstructor;
import ningenme.net.sample.common.filter.CustomAuthenticationFilter;
import ningenme.net.sample.common.filter.CustomPreAuthenticatedProcessingFilter;
import ningenme.net.sample.common.filter.PreAuthenticatedRequestMatcher;
import ningenme.net.sample.common.handler.CustomAuthenticationFailureHandler;
import ningenme.net.sample.common.handler.CustomAuthenticationSuccessHandler;
import ningenme.net.sample.domain.service.AuthenticationUserService;
import ningenme.net.sample.domain.service.AuthorizationUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    private final AuthenticationUserService authenticationUserService;
    private final AuthorizationUserService authorizationUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilter(customAuthenticationFilter())
                .addFilter(customPreAuthenticatedProcessingFilter())

                .formLogin()
                .loginProcessingUrl("/login").permitAll()

                .and()
                .authorizeRequests()
                .mvcMatchers(HttpMethod.POST,"/users").permitAll()
                .anyRequest().authenticated()

                .and()
                .exceptionHandling()

                .and()
                .csrf()
                .disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(daoAuthenticationProvider())
                .authenticationProvider(preAuthenticatedAuthenticationProvider());
    }

    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
        final DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(authenticationUserService);
        return daoAuthenticationProvider;
    }

    @Bean
    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
        final CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter();
        customAuthenticationFilter.setAuthenticationManager(authenticationManager());
        customAuthenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
        customAuthenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler);
        return customAuthenticationFilter;
    }

    @Bean
    PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider() {
        final PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider
                = new PreAuthenticatedAuthenticationProvider();
        preAuthenticatedAuthenticationProvider.setPreAuthenticatedUserDetailsService(authorizationUserService);
        return preAuthenticatedAuthenticationProvider;
    }

    @Bean
    CustomPreAuthenticatedProcessingFilter customPreAuthenticatedProcessingFilter() throws Exception {
        final CustomPreAuthenticatedProcessingFilter customPreAuthenticatedProcessingFilter
                = new CustomPreAuthenticatedProcessingFilter();
        customPreAuthenticatedProcessingFilter.setAuthenticationManager(authenticationManager());
        customPreAuthenticatedProcessingFilter.setRequiresAuthenticationRequestMatcher(new PreAuthenticatedRequestMatcher());
        return customPreAuthenticatedProcessingFilter;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        //ここでpassword突合時の暗号化の方法を決定できる
        return new BCryptPasswordEncoder();
    }

}
