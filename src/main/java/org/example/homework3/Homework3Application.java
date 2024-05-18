package org.example.homework3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
public class Homework3Application {

    public static void main(String[] args) {
        SpringApplication.run(Homework3Application.class, args);
    }

    @RestController
    @RequestMapping("/headers")
    public static class HeadersController {

        @GetMapping
        public String getAllHeaders(@RequestHeader Map<String, String> headers) {
            return headers.toString();
        }
    }

    @RestController
    @RequestMapping("/json")
    public static class JSONController {

        @PostMapping
        public JsonInfo processJson(@RequestBody JsonInfo jsonInfo) {
            JsonInfo.Info info = jsonInfo.getInfo();
            info.setId(123);
            jsonInfo.setInfo(info);
            return jsonInfo;
        }
    }

    public static class JsonInfo {
        private double price;
        private Info info;


        public Info getInfo() {
            return this.info;
        }

        public void setInfo(Info info) {
            this.info = info;
        }

        public static class Info {
            private int id;
            private String date;

            // Getters and setters

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }
        }
    }

    @ControllerAdvice
    public static class CustomExceptionHandler {

        @ExceptionHandler(Exception.class)
        @ResponseBody
        public String handleException(Exception ex) {
            return "Custom 502 Error: " + ex.getMessage();
        }
    }
}