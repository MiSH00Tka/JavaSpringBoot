package org.example.homework2.controller;

import org.example.homework2.dto.HeadersResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HeadersController {
    @GetMapping("/headers")
    public HeadersResponse getHeaders(@RequestHeader HttpHeaders httpHeaders) {
        Map<String, String> headers = new HashMap<>();
        for (var header : httpHeaders.entrySet())
            headers.put(header.getKey(), header.getValue().get(0));
        return new HeadersResponse(headers);
    }
}
