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

    public static class Builder {

        private String name;
        private int age;
        private String city;
        private String alias;

        public Builder setname(String name){
            this.name = name;

            return this;
        }

        public Builder setAge(int age){
            this.age = age;

            return this;
        }

        public Builder setCity(String city){
            this.city = city;

            return this;
        }

        public Builder setAlias(String alias){
            this.alias = alias;

            return this;
        }

        public UserEntity build(){
            return new UserEntity(this.name, this.age, this.city, this.alias);
        }
    }

}
