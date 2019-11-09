package com.sparta.wla.models;


public class Animal {
    private Gender gender;
    private int age = 0;
    private int id;
    private int breedOn;

    public Animal(Gender gender, int id) {
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

    public int getBreedOn() {
        return breedOn;
    }

    public void setBreedOn(int breedOn) {
        this.breedOn = breedOn;
    }

    public boolean canBreed(int month) {
        if (getGender().equals(Gender.FEMALE) && getAge() >= 10 && (month - breedOn) >= 12){
            breedOn = month;
            return true;
        } else {
            return false;
        }
    }
    public void incrementAge(){
        age++;
    }
}
