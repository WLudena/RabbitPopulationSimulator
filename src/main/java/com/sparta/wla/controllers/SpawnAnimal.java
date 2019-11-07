package com.sparta.wla.controllers;

import com.sparta.wla.models.Animal;
import com.sparta.wla.models.Gender;
import com.sparta.wla.models.Rabbit;

import java.sql.Time;
import java.util.*;

import org.apache.log4j.*;

public class SpawnAnimal {

    //private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private Random rand = new Random();
    private volatile List<Animal> rabbitList = new ArrayList<>();
    private List<Thread> rabbitThreads = new ArrayList<>();

    private int monthCounter = 1;

    private Logger log = Logger.getLogger(SpawnAnimal.class.getName());
    private volatile int rabbitIdentifier = 3;

    Runnable runnableRabbit = () -> rabbitThread(rabbitList);
    Runnable edenRunnable = () -> adanAndEvaRabbits();

    public void spawnRabbits() {
        rabbitList.add(new Rabbit(Gender.MALE, 1));
        rabbitList.add(new Rabbit(Gender.FEMALE, 2));
        int index = rabbitList.size() + 1;
        System.out.println("Initial population of rabbits: " + rabbitList.size());

        while (true) {
            List<Animal> tempRabbitList = new ArrayList<>();
            for (Animal rabbit : rabbitList) {
                if (rabbit.getAge() == 60) {
                    rabbitList.remove(rabbit);
                }
                rabbit.setAge(rabbit.getAge() + 1);
                if (rabbit.getGender().equals(Gender.FEMALE) && rabbit.getAge() >= 3) {
                    Animal newRabbit = new Rabbit(pickRandomGender(), index);
                    //System.out.println(newRabbit.toString());
                    tempRabbitList.add(newRabbit);
                    index++;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Total number of rabbits after " + monthCounter++ + " months :" + rabbitList.size());
            rabbitList.addAll(tempRabbitList);
        }
    }

    public void spawnRabbitsThreaded() {
        Thread edenRabbits = new Thread(edenRunnable);
        edenRabbits.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error(e);
        }
        System.out.println("Initial population of rabbits: " + rabbitList.size());
        while (true) {
            for (Animal rabbit : rabbitList) {
                if (rabbit.getGender().equals(Gender.FEMALE) && rabbit.getAge() >= 3) {
                    Thread rabbitThread = new Thread(runnableRabbit);
                    rabbitThreads.add(rabbitThread);
                    rabbitThread.start();
                }
            }
            System.out.println("Total number of rabbits after " + monthCounter++ + " months :" + rabbitList.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e);
            }
        }
    }

    private void rabbitThread(List<Animal> rabbitList) {
        int rabbitID = 0;
        rabbitID = rabbitIdentifier;
        rabbitIdentifier++;

        Animal rabbit = new Rabbit(pickRandomGender(), rabbitID);
        synchronized (rabbitList) {
            rabbitList.add(rabbit);
        }
        while (rabbit.getAge() < 60) {
            rabbit.setAge(rabbit.getAge() + 1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e);
            }
        }
        synchronized (rabbitList){
            rabbitList.remove(rabbit);
        }
    }

    private void adanAndEvaRabbits() {
        Animal adan = new Rabbit(Gender.MALE, 0);
        Animal eve = new Rabbit(Gender.FEMALE, 1);
        synchronized (rabbitList) {
            rabbitList.add(adan);
            rabbitList.add(eve);
        }
        while (adan.getAge() < 60 && eve.getAge() < 60) {
            adan.setAge(adan.getAge() + 1);
            eve.setAge(adan.getAge() + 1);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e);
            }
        }
        synchronized (rabbitList){
            rabbitList.remove(adan);
            rabbitList.remove(eve);
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
