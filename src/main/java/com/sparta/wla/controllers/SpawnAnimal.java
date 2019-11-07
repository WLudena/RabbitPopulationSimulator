package com.sparta.wla.controllers;

import com.sparta.wla.models.Animal;
import com.sparta.wla.models.Fox;
import com.sparta.wla.models.Gender;
import com.sparta.wla.models.Rabbit;

import java.util.*;

import org.apache.log4j.*;

public class SpawnAnimal {

    //private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Random rand = new Random();
    private volatile List<Animal> rabbitList = new ArrayList<>();
    private volatile List<Animal> foxList = new ArrayList<>();
    private List<Thread> rabbitThreads = new ArrayList<>();
    private int monthlyEatenRabbits = 0;

    private int monthCounter = 0;

    private Logger log = Logger.getLogger(SpawnAnimal.class.getName());
    private volatile int rabbitIdentifier = 3;

    {
        adanAndEveRabbits();
        adanAndEveFoxes();
    }

    private void spawnRabbits() {

        int index = rabbitList.size() + 1;

        List<Animal> tempRabbitList = new ArrayList<>();

        for (Animal rabbit : rabbitList) {
            if (rabbit.getAge() == 60) {
                rabbitList.remove(rabbit);
            }
            rabbit.setAge(rabbit.getAge() + 1);
            if (rabbit.getGender().equals(Gender.FEMALE) && rabbit.getAge() >= 3) {
                for (int i = 0; i < rand.nextInt(14) + 1; i++) {
                    Animal newRabbit = new Rabbit(pickRandomGender(), index);
                    tempRabbitList.add(newRabbit);
                    index++;
                }
            }
        }
        rabbitList.addAll(tempRabbitList);
    }

    private void spawnFoxes() {
        int index = foxList.size() + 1;

        List<Animal> tempFoxList = new ArrayList<>();

        for (Animal fox : foxList) {
            if (fox.getGender().equals(Gender.FEMALE) && fox.getAge() >= 10 && monthCounter % 12 == 0) {
                for (int i = 0; i < rand.nextInt(11); i++) {
                    tempFoxList.add(new Fox(pickRandomGender(), index));
                    index++;
                }
            }
            fox.setAge(fox.getAge() + 1);
        }
        foxList.addAll(tempFoxList);
    }

    public void spawnPopulation() {
        if(monthCounter < 10){
            spawnRabbits();
            monthCounter++;
        }else{
            spawnRabbits();
            spawnFoxes();
            feedFoxes();
            monthCounter++;
        }
    }

    public List<Animal> getRabbitList() {
        return rabbitList;
    }

    public List<Animal> getFoxList() {
        return foxList;
    }

    public int getMonthCounter(){
        return monthCounter;
    }

    private void feedFoxes() {
        //Can start eating rabbits right after being born
        int rabbitsEaten = 0;
        for (Animal fox : foxList) {
                for (int i = 0; i < rand.nextInt(20) + 1; i++) {
                    rabbitList.remove(i);
                    rabbitsEaten++;
                }
        }
        monthlyEatenRabbits = rabbitsEaten;
    }

    public int getEatenRabbits() {
        return monthlyEatenRabbits;

    }

    private void adanAndEveRabbits() {
        rabbitList.add(new Fox(Gender.FEMALE, 0));
        rabbitList.add(new Fox(Gender.MALE, 1));
        for (Animal rabbit : rabbitList) {
            rabbit.setAge(3);
        }

    }

    private void adanAndEveFoxes() {
        foxList.add(new Fox(Gender.FEMALE, 0));
        foxList.add(new Fox(Gender.MALE, 1));
        for(Animal fox : foxList){
            fox.setAge(10);
        }
    }

    private Gender pickRandomGender() {
        if (rand.nextBoolean()) {
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }

    public String counterMalesAndFemales(){
        int males = 0;
        int females = 0;
        for(Animal rabbit : rabbitList){
            if(rabbit.getGender().equals(Gender.FEMALE)){
                females++;
            }else{
                males++;
            }
        }
        return "Number of males: " + males + " -- Number of females: "+ females;
    }

}
