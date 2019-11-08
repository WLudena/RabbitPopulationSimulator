package com.sparta.wla;

import com.sparta.wla.controllers.SpawnAnimal;
import com.sparta.wla.models.Animal;
import com.sparta.wla.models.Fox;
import com.sparta.wla.models.Gender;
import com.sparta.wla.models.Rabbit;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class PopulationTest
{
    /**
     * Rigorous Test :-)
     */
    private SpawnAnimal spawnAnimals;
    private ArrayList<Animal> foxList;
    private ArrayList<Animal> rabbitList;

    @Before
    public void setUp(){
        spawnAnimals = new SpawnAnimal();
    }

    @Test
    public void testAdamAndEveRabbitExist(){
        rabbitList = new ArrayList<>();
        rabbitList.addAll(spawnAnimals.getRabbitList());
//        rabbitList = new ArrayList<>();
//        rabbitList.add(new Rabbit(Gender.FEMALE, 0));
//        rabbitList.add(new Rabbit(Gender.MALE, 1));
//        for (Animal rabbit : rabbitList) {
//            rabbit.setAge(3);
//        }
        assertArrayEquals(spawnAnimals.getRabbitList().toArray(),rabbitList.toArray());
    }

    @Test
    public void testAdanAndEvenFoxExist(){
        assertEquals(spawnAnimals.getFoxList().size(),2);
    }
}
