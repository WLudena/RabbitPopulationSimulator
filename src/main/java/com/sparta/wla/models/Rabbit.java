package com.sparta.wla.models;

public class Rabbit extends Animal {

    private int rabbitID;

    public Rabbit(Gender gender, int rabbitID) {
        super(gender, rabbitID);
    }

    @Override
    public String toString(){
        return "Rabbit created! -- Rabbit ID: " + getId() + ", rabbit gender: " + getGender() + ", rabbit age: " + getAge();
    }
}
