package de.beanfactory.samples.mapstruct.model;

import lombok.Data;

@Data
public class TestSourceBean {
    private int id;
    private String data;

    public TestSourceBean(int id, String data) {
        this.id = id;
        this.data = data;
    }
}
