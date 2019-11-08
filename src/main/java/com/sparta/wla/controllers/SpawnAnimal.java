package com.sparta.wla.controllers;

import com.sparta.wla.displays.DisplayPopulation;
import com.sparta.wla.models.Animal;
import com.sparta.wla.models.Fox;
import com.sparta.wla.models.Gender;
import com.sparta.wla.models.Rabbit;

import java.util.*;

import org.apache.log4j.*;

public class SpawnAnimal {

    //private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Logger log = Logger.getLogger(SpawnAnimal.class);

    private Random rand = new Random();
    private List<Animal> rabbitList = new ArrayList<>();
    private List<Animal> foxList = new ArrayList<>();
    private int foxIntroduction = 6; //Figure this out

    private int maleRabbitCount = 1;
    private int femaleRabbitCount = 1;
    private int monthlyEatenRabbits = 0;
    private int monthCounter = 0;

    {
        adanAndEveRabbits();
        adanAndEveFoxes();
    }

    public void spawnPopulation() {
        if (monthCounter < foxIntroduction) { //In order attempt rabbit population control, foxes are introduced on month 6
            spawnRabbits();
            monthCounter++;
//            try{
//                Thread.sleep(1000);
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
        } else {
            spawnRabbits();
            spawnFoxes();
            feedFoxes();
            monthCounter++;
//            try{
//                Thread.sleep(1000);
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
        }
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

                    //Could do this in one line but did it this way so I could
                    //increment male/female counter every time a new one was created

                    Animal newRabbit = new Rabbit(pickRandomGender(), index);
                    tempRabbitList.add(newRabbit);
                    if (newRabbit.getGender().equals(Gender.FEMALE)) {
                        femaleRabbitCount++;
                    } else {
                        maleRabbitCount++;
                    }
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
            if (fox.getGender().equals(Gender.FEMALE) && fox.getAge() >= 10 && monthCounter % 12 == 0) { //Right now, foxes reproduce once every 12 months, no matter when introduced
                for (int i = 0; i < rand.nextInt(11); i++) {
                    tempFoxList.add(new Fox(pickRandomGender(), index));
                    index++;
                }
            }
            fox.setAge(fox.getAge() + 1);
        }
        foxList.addAll(tempFoxList);
    }


    public List<Animal> getRabbitList() {
        return rabbitList;
    }

    public List<Animal> getFoxList() {
        return foxList;
    }

    public int getEatenRabbits() {
        return monthlyEatenRabbits;
    }

    public int getMonthCounter() {
        return monthCounter;
    }

    public int getMaleRabbitCount() {
        return maleRabbitCount;
    }

    public int getFemaleRabbitCount() {
        return femaleRabbitCount;
    }

    private void feedFoxes() {
        //Can start eating rabbits right after being born
        int rabbitsEaten = 0;
        for (Animal fox : foxList) {
            for (int i = 0; i < rand.nextInt(20) + 1; i++) {
                rabbitList.remove(rand.nextInt(rabbitList.size()));
                rabbitsEaten++;
            }
        }
        monthlyEatenRabbits = rabbitsEaten;
    }

    private void adanAndEveRabbits() {
        rabbitList.add(new Rabbit(Gender.FEMALE, 0));
        rabbitList.add(new Rabbit(Gender.MALE, 1));
        for (Animal rabbit : rabbitList) {
            rabbit.setAge(3);
        }
    }

    private void adanAndEveFoxes() {
        foxList.add(new Fox(Gender.FEMALE, 0));
        foxList.add(new Fox(Gender.MALE, 1));
        for (Animal fox : foxList) {
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
}
