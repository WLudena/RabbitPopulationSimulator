package com.sparta.wla.models;

public class Fox extends Animal{

    public Fox(Gender gender, int foxID) {
        super(gender, foxID);
    }
    
    @Override
    public String toString(){
        return "Fox spawned! -- Fox ID: " + getId() + ", fox gender: " + getGender();
    }
}
