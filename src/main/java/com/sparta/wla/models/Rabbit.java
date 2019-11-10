package com.sparta.wla.models;

public class Rabbit extends Animal {

    public Rabbit(Gender gender, int rabbitID) {
        super(gender, rabbitID);
    }

    @Override
    public boolean canBreed(int month) {
        return true;
    }

    @Override
    public String toString(){
        return "Rabbit created! -- Rabbit ID: " + getId() + ", rabbit gender: " + getGender() + ", rabbit age: " + getAge();
    }
}
