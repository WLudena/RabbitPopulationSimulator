package com.sparta.wla.controllers;

import com.sparta.wla.displays.DisplayManager;

/**
 * Hello world!
 *
 */
public abstract class Starter
{
    public static void main(String args[]) throws InterruptedException {
        new DisplayManager().startSimulation();
    }
}
