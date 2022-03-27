package ningenme.net.sample.common.config;

import lombok.RequiredArgsConstructor;
import ningenme.net.sample.common.handler.CustomAuthenticationFailureHandler;
import ningenme.net.sample.common.handler.CustomAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .permitAll()

                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .permitAll()
                .usernameParameter("mail")
                .passwordParameter("password")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)

                .and()
                .csrf()
                .disable();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        //ここでpassword突合時の暗号化の方法を決定できる
        return new BCryptPasswordEncoder();
    }

}
