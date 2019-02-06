package com.mhp.boot.camp.hateoasdemo.controller;

import com.mhp.boot.camp.hateoasdemo.repo.Wife;
import com.mhp.boot.camp.hateoasdemo.service.WifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wife")
public class WifeController {

    private final WifeService wifeService;

    public WifeController(@Autowired WifeService wifeService) {
        this.wifeService = wifeService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Wife>> getAllWifes() {
        return ResponseEntity.ok(wifeService.findAllWifes());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Wife> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(wifeService.findWifeById(id));
    }

    @PostMapping
    public ResponseEntity<Wife> create(@RequestBody Wife wife) {
        return ResponseEntity.status(HttpStatus.CREATED).body(wifeService.saveOrUpdate(wife));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Wife> deleteById(@PathVariable("id") Integer id) {
        wifeService.deleteWife(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Wife> update(@RequestBody Wife wife) {
        return ResponseEntity.status(HttpStatus.OK).body(wifeService.saveOrUpdate(wife));
    }

}
