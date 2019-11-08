package com.sparta.wla.displays;

import com.sparta.wla.controllers.SpawnAnimal;

import java.util.Scanner;
import org.apache.log4j.*;

public class DisplayPopulation {
    private SpawnAnimal newPopulation = new SpawnAnimal();
    private Logger log = Logger.getLogger(DisplayPopulation.class);

    public void displaySimulation() {

        System.out.println("Welcome to the Rabbit & Foxes population simulator! \n");
        System.out.println("Please set the number of months the simulation should run for: ");
        Scanner input = new Scanner(System.in);
        int duration = input.nextInt();
        System.out.println("Initialising simulation! ");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(500);
                System.out.println("...");
            } catch (InterruptedException e) {
                log.error(e);
            }
        }
        System.out.println("Initialized!");
        System.out.println("\nInitial population of rabbits: " + newPopulation.getRabbitList().size());
        System.out.println("Initial population of foxes: " + newPopulation.getFoxList().size() + "\n");

        while (true) {
            newPopulation.spawnPopulation();
            System.out.println("-------------------------------------------------------------");
            System.out.println("\nMonth number :" + newPopulation.getMonthCounter());
            System.out.println("\nRabbit population: " + newPopulation.getRabbitList().size());
            System.out.println("\nFox population: " + newPopulation.getFoxList().size());
            System.out.println("\nNumber of rabbits eaten: " + newPopulation.getEatenRabbits());
            System.out.println("\nTotal number of male rabbits: " + newPopulation.getMaleRabbitCount());
            System.out.println("Total number of female rabbits: " + newPopulation.getFemaleRabbitCount());
            System.out.println("\n-------------------------------------------------------------");

        }
    }
}
