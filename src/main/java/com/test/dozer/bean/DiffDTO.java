package com.test.dozer.bean;

import org.dozer.Mapping;

/**
 * Created by szh on 2017/12/1.
 */
public class DiffDTO {

    private Integer id;

    @Mapping("username")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DiffDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
