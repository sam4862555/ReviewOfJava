package com.test.dozer.bean;

import org.dozer.Mapping;

/**
 * Created by szh on 2017/12/1.
 */
public class DiffVO {

    private Integer id;

    @Mapping("name")
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "DiffVO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}
