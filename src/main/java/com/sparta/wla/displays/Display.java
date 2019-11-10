package com.sparta.wla.displays;

import com.sparta.wla.controllers.SpawnAnimal;

public class Display {

    public void displayInformation(SpawnAnimal spawnAnimal) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("\nMonth number :" + spawnAnimal.getMonthCounter());
        System.out.println("\nRabbit population: " + spawnAnimal.getRabbitList().size());
        System.out.println("\nFox population: " + spawnAnimal.getFoxList().size());
        System.out.println("\nNumber of rabbits eaten: " + spawnAnimal.getEatenRabbits());
        System.out.println("\nTotal number of male rabbits: " + spawnAnimal.getMaleRabbitCount());
        System.out.println("Total number of female rabbits: " + spawnAnimal.getFemaleRabbitCount());
        System.out.println("\n-------------------------------------------------------------");
    }

    public void displayInitialInformation(SpawnAnimal spawnAnimal) {
        System.out.println("Initialized!");
        System.out.println("\nMonth:" + spawnAnimal.getMonthCounter());
        System.out.println("\nInitial population of rabbits: " + spawnAnimal.getRabbitList().size());
        System.out.println("Initial population of foxes: " + spawnAnimal.getFoxList().size() + "\n");
    }
}
