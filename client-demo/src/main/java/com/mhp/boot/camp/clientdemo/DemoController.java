package com.mhp.boot.camp.clientdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class DemoController {


    @GetMapping("/person")
    public ResponseEntity<?> getPersons(@RequestHeader("X-Secret") String secret) {
        if (!"S3Cr37".equals(secret)) {
            return ResponseEntity.badRequest().body("I dare you, I double dare you");
        }
        Person seb = new Person("Sebastian", 29);
        Person mad = new Person("Madonna", 76);
        Person carl = new Person("Carl", 43);

        return ResponseEntity.ok(Arrays.asList(seb, mad, carl));

    }

    @Data
    @AllArgsConstructor
    protected static class Person {
        private final String name;
        private final Integer age;
    }

}
