package com.ztz.flux_server_anotation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @Date 2019/3/4 16:18.
 */
@RestController
public class BasicController {
    @GetMapping("/helloWorld")
    public Mono<String> sayHelloWorld() {
        return Mono.just("Hello World");
    }
}
