package com.sparta.wla.controllers;

import com.sparta.wla.displays.DisplayPopulation;

/**
 * Hello world!
 *
 */
public abstract class Starter
{
    public static void main(String args[]) throws InterruptedException {
        new DisplayPopulation().displaySimulation();
        //System.out.println(10-(-2));
    }
}
