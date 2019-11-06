package com.sparta.wla.models;


public class Animal  {
    private Gender gender;
    private int age = 0;
    private int id;

    public Animal(Gender gender, int id){
        this.id = id;
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }
}
