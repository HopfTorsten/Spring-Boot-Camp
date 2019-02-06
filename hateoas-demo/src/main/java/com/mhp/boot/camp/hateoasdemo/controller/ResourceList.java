package com.mhp.boot.camp.hateoasdemo.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
public class ResourceList<DTO extends Object> extends ResourceSupport {

    private List<DTO> data;

    public ResourceList(List<DTO> data) {
        this.data = data;
    }

    public void addDataEntry(DTO entry) {
        if (data == null) {
            data = new LinkedList<>();
        }
        data.add(entry);
    }


}
