package me.adhikasetyap.cloudcontractbug;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public Mono<String> sayHello(@RequestParam String name) {
    return Mono.create(sink -> {
      String greeting = "Hello ".concat(name);
      sink.success(greeting);
    });
  }
}
