package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Player p = new Player();
        Dice d = new Dice();
        Scanner sc = new Scanner(System.in);
        System.out.println("Say my name...");
        String name = sc.next();
        p.name = name;
        System.out.println(p.toString());
        System.out.println(d.toString());
        awakening(p, d, sc);
    }

    public static void awakening(Player p, Dice d, Scanner sc) {
        int roll;
        System.out.println("You awaken from your chrysalis into the new world, a world filled with danger and conquest.");
        System.out.println("Your first action must be to take your first step into the new world. Type 'roll' in the console to proceed.");
        if (sc.next().equals("roll")) {
            roll = d.roll();
            System.out.println(d.toString());
            if (roll <= 10) {
                System.out.println("You tried to run, but ended up crawling instead. You slowly inch your way forward without consequence.");
            }
            if (roll > 10) {
                System.out.println("You tried to run, which ended up successful! You run forwards through the path ahead of you.");
            }
        } else {
            System.out.println("Error: that was not an option");
        }
        System.out.println("Now that you have escaped, an enemy rolls into your path. The first step of many.");

    }
}
