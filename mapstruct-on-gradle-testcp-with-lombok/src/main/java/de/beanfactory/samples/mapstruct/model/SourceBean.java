package de.beanfactory.samples.mapstruct.model;

import lombok.Data;

@Data
public class SourceBean {
    int id;
    String data;

    public SourceBean(int id, String data) {
        this.id = id;
        this.data = data;
    }
}
