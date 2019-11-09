package com.sparta.wla.models;

public class Fox extends Animal{

    private int breedOn;

    public Fox(Gender gender, int foxID) {
        super(gender, foxID);
    }

    public void setBreedOn(int breedOn) {
        this.breedOn = breedOn;
    }

    @Override
    public boolean canBreed(int month) {
        {
            if (getGender().equals(Gender.FEMALE) && getAge() >= 10 && (month - breedOn) >= 12){
                breedOn = month;
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString(){
        return "Fox spawned! -- Fox ID: " + getId() + ", fox gender: " + getGender();
    }
}
