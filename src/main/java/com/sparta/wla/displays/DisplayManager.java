package com.sparta.wla.displays;

import com.sparta.wla.exceptions.SimulationException;
import com.sparta.wla.controllers.SpawnAnimal;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.*;

public class DisplayManager {
    private SpawnAnimal newPopulation = new SpawnAnimal();
    private Display display = new Display();
    private Logger log = Logger.getLogger(DisplayManager.class);
    private Scanner scanner = new Scanner(System.in);

    public void startSimulation() {
        try {
            int duration = displayDurationRequest();
            display.displayInitialInformation(newPopulation);
            for(int i = 0; i < duration; i++){
                newPopulation.spawnPopulation();
                display.displayInformation(newPopulation);
            }
        } catch (SimulationException | OutOfMemoryError e) {
            log.error(e);
        }
    }

    public int displayDurationRequest() throws SimulationException {
        System.out.println("Welcome to the Rabbit & Foxes population simulator! \n");
        System.out.println("Please set the number of months the simulation should run for: ");
        try{
            int duration = scanner.nextInt();
            return duration;
        }catch (InputMismatchException e){
            throw new SimulationException("Incorrect character!");
        }
    }

}
