package com.mhp.snippetsdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
public class SecretController {

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPersons(@RequestHeader(required = false, defaultValue = "nope", name = "X-Secret") String secret) {

        if ("S3Cr37".equals(secret)) {

            Person tom = new Person("Tom", "Sawyer", 13);
            Person gerald = new Person("Geralt", "von Riva", 38);
            Person karlV = new Person("Karl", "der Fünfte", 500);

            final List<Person> people = Arrays.asList(tom, gerald, karlV);
            return ResponseEntity.ok(people);
        } else {
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body(Collections.emptyList());
        }


    }

    @Data
    @AllArgsConstructor
    protected static class Person {
        private String firstName;
        private String lastName;
        private Integer age;
    }


}
