package com.example.orderservice;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/orders")
public class Controller {
    private final Environment environment;

    @GetMapping("/message")
    public String message(){
        log.info("hello");
        return "First service header";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request){
        log.info("server port= {}", request.getServerPort());
        return "First service Server port = { " + environment.getProperty("local.server.port") + " }";
    }
}
