package ningenme.net.sample.infrastructure.redis;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ningenme.net.sample.infrastructure.redis.config.RedisConfig;
import ningenme.net.sample.domain.entity.User;
import ningenme.net.sample.domain.value.SessionId;
import ningenme.net.sample.infrastructure.redis.dto.UserRedisDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRedisRepository {

    @Qualifier(RedisConfig.SESSION_ID_USER_REDIS_TEMPLATE)
    private final RedisTemplate<String, UserRedisDto> redisTemplate;

    public void post(
            @NonNull final SessionId sessionId,
            @NonNull final User user) {
        ValueOperations<String, UserRedisDto> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(sessionId.getValue().toString(), new UserRedisDto(user));
    }
}
