package com.mhp.beansdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudController {

    @GetMapping("/blame")
    public ResponseEntity<String> getBlameFor(
            @RequestParam(name = "victim", defaultValue = "Jimmy") String toBlame) {

        return ResponseEntity.ok("You suck " + toBlame);

    }

    @PostMapping("/blame")
    public ResponseEntity<String> saveBlame(@RequestBody String newBlame) {

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
