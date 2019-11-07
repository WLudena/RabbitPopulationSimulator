package com.sparta.wla.models;

public class Rabbit extends Animal {

    private int rabbitID;

    public Rabbit(Gender gender, int rabbitID) {
        super(gender, rabbitID);
        this.rabbitID = rabbitID;
    }

    public int getRabbitID() {
        return rabbitID;
    }

    @Override
    public String toString(){
        return "Rabbit created! -- Rabbit ID: " + rabbitID + ", rabbit gender: " + getGender() + ", rabbit age: " + getAge();
    }
}
