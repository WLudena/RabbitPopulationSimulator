package com.sparta.wla.models;

public class Fox extends Animal{

    private int foxID;

    public Fox(Gender gender, int foxID) {
        super(gender, foxID);
        this.foxID = foxID;
    }

    public int getFoxID() {
        return foxID;
    }

    @Override
    public String toString(){
        return "Rabbit created! -- Rabbit ID: " + foxID + ", rabbit gender: " + getGender();
    }
}
