package com.peihua.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;
    private String name;
    private Date birdaty;

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

    public Date getBirdaty() {
        return birdaty;
    }

    public void setBirdaty(Date birdaty) {
        this.birdaty = birdaty;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birdaty=" + birdaty +
                '}';
    }

}
