package com.sparta.wla.displays;

import com.sparta.wla.controllers.SpawnAnimal;

public class DisplayPopulation {
    private SpawnAnimal newPopulation = new SpawnAnimal();

    public void displaySimulation(){
        System.out.println("\n" + "Initial population of rabbits: " + newPopulation.getRabbitList().size());
        System.out.println("Initial population of foxes: " + newPopulation.getFoxList().size() + "\n");
        while(newPopulation.getMonthCounter() < 24){
            newPopulation.spawnPopulation();
            System.out.println("-------------------------------------------------------------\n");
            System.out.println("Month number :" + newPopulation.getMonthCounter() + "\n");
            System.out.println("Rabbit population: " + newPopulation.getRabbitList().size() + "\n");
            System.out.println("Fox population: " + newPopulation.getFoxList().size() + "\n");
            System.out.println("Number of rabbits eaten: " + newPopulation.getEatenRabbits() + "\n");
            System.out.println(newPopulation.counterMalesAndFemales() + "\n");
            System.out.println("-------------------------------------------------------------");

        }
    }
}
