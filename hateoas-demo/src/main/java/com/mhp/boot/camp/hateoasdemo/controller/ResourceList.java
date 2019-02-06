package com.mhp.boot.camp.hateoasdemo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Link;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceList<DTO extends Object> {

    private List<DTO> data;
    private List<Link> links = new LinkedList<>();

    public ResourceList(List<DTO> data) {
        this.data = data;
    }

    public void addLink(Link link) {
        links.add(link);
    }

    public void addDataEntry(DTO entry) {
        if (data == null) {
            data = new LinkedList<>();
        }
        data.add(entry);
    }


}
