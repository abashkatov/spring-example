package com.example.api.controller;

import com.example.api.controller.dto.HelloWorldRequest;
import com.example.api.controller.dto.HelloWorldResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/*

http(s)://ya.ru/path/to/resource?q=1&w=2#sdfsdf
GET POST
PATCH PUT DELETE

GET /api/v1/user
GET /api/v1/user/4
PATCH /api/v1/user/4

 */

@RestController
@RequestMapping("/api/v1/hello-world")
@Validated
public class HelloWorldController {

    @GetMapping
    public HelloWorldResponse helloWorld() {
        var response = new HelloWorldResponse();
        response.setMessage("Hello Get!");

        return response;
    }

    @PostMapping("/{userId}")
    public HelloWorldResponse postHelloWorld(
        @PathVariable("userId") Long userId,
        @RequestBody @Validated HelloWorldRequest request
    ) {
        var response = new HelloWorldResponse();
        response.setMessage("Ask: " + request.getMessage());
        response.setUserId(userId);

        return response;
    }
}
