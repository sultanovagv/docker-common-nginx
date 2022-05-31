package docker.common.controller;

import docker.common.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CounterController {

    private final CounterService service;

    @GetMapping("/hello")
    public String getMessage() {
        return service.getCounter();
    }

}
