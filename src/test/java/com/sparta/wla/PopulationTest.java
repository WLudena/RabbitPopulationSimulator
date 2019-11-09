package com.sparta.wla;

import com.sparta.wla.controllers.SpawnAnimal;
import com.sparta.wla.models.Animal;
import com.sparta.wla.models.Fox;
import com.sparta.wla.models.Gender;
import com.sparta.wla.models.Rabbit;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class PopulationTest {
    /**
     * Rigorous Test :-)
     */
    private SpawnAnimal spawnAnimals;
    private List<Animal> foxList = new ArrayList<>();
    private List<Animal> rabbitList = new ArrayList<>();

    @Before
    public void setUp() {
        spawnAnimals = new SpawnAnimal();
    }

    @Test
    public void testAdanAndEveRabbitExist() {
        rabbitList.addAll(spawnAnimals.getRabbitList());
        assertArrayEquals(spawnAnimals.getRabbitList().toArray(), rabbitList.toArray());
    }

    @Test
    public void testAdanAndEveFoxExist() {
        foxList.addAll(spawnAnimals.getFoxList());
        assertArrayEquals(spawnAnimals.getFoxList().toArray(), foxList.toArray());
    }

    @Test
    public void testRabbitPopulationIncreases() {
        List<Animal> initialRabbits = new ArrayList<>();
        initialRabbits.addAll(spawnAnimals.getRabbitList());
        for (int i = 0; i < 3; i++) {
            spawnAnimals.spawnPopulation();
        }
        assertTrue(spawnAnimals.getRabbitList().size() > initialRabbits.size());
    }

    @Test
    public void testFoxPopulationIncreases() {
        List<Animal> initialFoxes = new ArrayList<>();
        initialFoxes.addAll(spawnAnimals.getFoxList());
        for (int i = 0; i < 11; i++) {
            spawnAnimals.spawnPopulation();
        }
        assertTrue(spawnAnimals.getFoxList().size() > initialFoxes.size());
    }

    @Ignore // Just to show that we are aware of the problem after reaching a certain point
    @Test(expected = OutOfMemoryError.class)
    public void testProgramOutOfMemory(){
        while(true){
            spawnAnimals.spawnPopulation();
        }
    }

    @Test
    public void testRabbitHasID(){
        assertNotNull(spawnAnimals.getRabbitList().get(1).getId());
    }

    @Test
    public void testRabbitHasGender(){
        assertNotNull(spawnAnimals.getRabbitList().get(1).getGender());
    }

    @Test
    public void testFoxHasID(){
        assertNotNull(spawnAnimals.getFoxList().get(1).getId());
    }

    @Test
    public void testFoxHasGender(){
        assertNotNull(spawnAnimals.getFoxList().get(1).getGender());
    }
}
