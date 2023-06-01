package com.company;

import java.util.*;

public class Dice
{
    public Random r;
    public int returner;

    public Dice() {
        this.r = new Random();
    }

    public int roll() {
        returner = r.nextInt(20);
        return returner;
    }


    public String toString() {
        return "You have rolled a " + returner + "!";
    }
}
