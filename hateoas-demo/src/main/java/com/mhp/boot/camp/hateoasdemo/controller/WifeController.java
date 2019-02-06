package com.mhp.boot.camp.hateoasdemo.controller;

import com.mhp.boot.camp.hateoasdemo.repo.Wife;
import com.mhp.boot.camp.hateoasdemo.service.WifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpMethod;
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

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/wife")
public class WifeController {

    private final WifeService wifeService;

    public WifeController(@Autowired WifeService wifeService) {
        this.wifeService = wifeService;
    }

    @GetMapping
    public ResponseEntity<ResourceList<LinkedWife>> getAllWifes() {
        final List<LinkedWife> wifes = new LinkedList<>();
        wifeService.findAllWifes().forEach(w -> wifes.add(map(w)));

        final ResourceList<LinkedWife> linkedWifeResourceList = new ResourceList<>(wifes);

        Link self = ControllerLinkBuilder.
                linkTo(ControllerLinkBuilder.methodOn(WifeController.class).getAllWifes())
                .withSelfRel()
                .withType(HttpMethod.GET.name());

        Link create = ControllerLinkBuilder.
                linkTo(ControllerLinkBuilder.methodOn(WifeController.class).create(null))
                .withSelfRel()
                .withType(HttpMethod.POST.name());
        linkedWifeResourceList.add(self);
        linkedWifeResourceList.add(create);


        return ResponseEntity.ok(linkedWifeResourceList);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<LinkedWife> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(map(wifeService.findWifeById(id)));
    }

    @PostMapping
    public ResponseEntity<LinkedWife> create(@RequestBody Wife wife) {
        return ResponseEntity.status(HttpStatus.CREATED).body(map(wifeService.saveOrUpdate(wife)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LinkedWife> deleteById(@PathVariable("id") Integer id) {
        wifeService.deleteWife(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<LinkedWife> update(@RequestBody Wife wife) {
        return ResponseEntity.status(HttpStatus.OK).body(map(wifeService.saveOrUpdate(wife)));
    }

    private LinkedWife map(Wife wife) {
        final LinkedWife linkedWife = new LinkedWife(wife.getId(), wife.getNickName(), wife.getAge(), wife.getBreastSize());
        final Link selfLink = ControllerLinkBuilder.
                linkTo(ControllerLinkBuilder.methodOn(WifeController.class).getById(wife.getId()))
                .withSelfRel()
                .withType(HttpMethod.GET.name());


        final Link delLink = ControllerLinkBuilder.
                linkTo(ControllerLinkBuilder.methodOn(WifeController.class).deleteById(wife.getId()))
                .withSelfRel()
                .withType(HttpMethod.DELETE.name());

        final Link updateLink = ControllerLinkBuilder.
                linkTo(ControllerLinkBuilder.methodOn(WifeController.class).update(null))
                .withSelfRel()
                .withType(HttpMethod.PUT.name());

        linkedWife.add(delLink);
        linkedWife.add(selfLink);
        linkedWife.add(updateLink);
        return linkedWife;
    }

}
