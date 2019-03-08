package com.ztz.flux_server_anotation.services;

import com.ztz.flux_server_anotation.modle.User;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date 2019/3/4 16:25.
 */
@Service
public class UserService {
    private final Map<String, User> data = new ConcurrentHashMap<>();

    public Flux<User> list() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId("id_" + i);
            user.setName("name_" + i);
            user.setEmail("email_" + i);
            data.put("zhangSan", user);
        }

        return Flux.fromIterable(this.data.values());
    }

    public Flux<User> getById(final Flux<String> ids) {
        return ids.flatMap(id -> Mono.justOrEmpty(this.data.get(id)));
    }

    public Mono<User> getById(final String id) {
        return Mono.justOrEmpty(this.data.get(id))
                .switchIfEmpty(Mono.error(new InvalidConfigurationPropertyValueException("id", "not found", "datas no value")));
    }

    public Mono<User> createOrUpdate(final User user) {
        this.data.put(user.getId(), user);
        return Mono.just(user);
    }

    public Mono<User> delete(final String id) {
        return Mono.justOrEmpty(this.data.remove(id));
    }
}
