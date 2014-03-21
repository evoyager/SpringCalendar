package com.diosoft.calendar.common;

/**
 * Created by EVGENIY on 21.03.14.
 */
public class Person {
    private final String firstName;
    private final String secondName;
    private final int age;
    private final String email;

    public String getEmail() {
        return email;
    }

    private Person(Builder builder){
        this.firstName = builder.firstName;
        this.secondName = builder.secondName;
        this.age = builder.age;
        this.email = builder.email;
    }

    public static class Builder {
        private String firstName;
        private String secondName;
        private int age;
        private String email;

        public Builder(){}

        public Builder setFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public Builder setSecondName(String secondName){
            this.secondName = secondName;
            return this;
        }

        public Builder setAge(int age){
            this.age = age;
            return this;
        }

        public Builder setEmail(String email){
            this.email = email;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
