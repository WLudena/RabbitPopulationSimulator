package com.sparta.wla.controllers;

import com.sparta.wla.models.Animal;
import com.sparta.wla.models.Gender;
import com.sparta.wla.models.Rabbit;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class SpawnAnimal {

    //private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Random rand = new Random();
    private ArrayList<Rabbit> rabbitList = new ArrayList<>();

    public void spawnRabbitPopulation() {
        rabbitList.add(new Rabbit(Gender.MALE, 1));
        rabbitList.add(new Rabbit(Gender.FEMALE, 2));
        int index = rabbitList.size() + 1;

        while (true) {
            ArrayList<Rabbit> tempRabbitList = new ArrayList<>();
            for (Rabbit rabbit : rabbitList) {
                if (rabbit.getGender().equals(Gender.FEMALE)) {
                    Rabbit newRabbit = new Rabbit(pickRandomGender(), index);
                    System.out.println(rabbit.toString());
                    tempRabbitList.add(newRabbit);
                    index++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            rabbitList.addAll(tempRabbitList);
        }
    }

    private Gender pickRandomGender() {
        if (rand.nextBoolean()) {
            return Gender.MALE;
        } else {
            return Gender.MALE;
        }
    }

}
