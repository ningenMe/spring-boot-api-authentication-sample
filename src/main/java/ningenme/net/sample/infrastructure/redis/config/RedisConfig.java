package ningenme.net.sample.infrastructure.redis.config;

import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.domain.value.SessionId;
import ningenme.net.sample.infrastructure.redis.dto.UserRedisDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    public static final String SESSION_ID_USER_REDIS_TEMPLATE = "SessionIdUserRedisTemplate";

    @Bean(SESSION_ID_USER_REDIS_TEMPLATE)
    RedisTemplate<String, UserRedisDto> sessionIdUserRedisTemplate(
            RedisConnectionFactory redisConnectionFactory
    ) {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(UserRedisDto.class));
        return redisTemplate;
    }
}
