package org.example.homework8;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @ApiMethod
    @GetMapping("/api/example")
    public String exampleApiMethod() {
        return "Method was called";
    }
}