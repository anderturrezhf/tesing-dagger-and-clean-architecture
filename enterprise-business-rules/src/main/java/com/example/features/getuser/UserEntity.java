package com.example.features.getuser;

/**
 * Created by Ander Túrrez on 25/09/16.
 */

public class UserEntity {

    private String name;
    private int age;
    private String city;
    private String alias;

    public UserEntity() {
    }

    public UserEntity(String name, int age, String city, String alias) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getAlias() {
        return alias;
    }
}
