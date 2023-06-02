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
        System.out.println("You must fight. Type 'roll' to make your move.");
        Enemy dungeater = new Enemy("Dung Eater", 100, 10);
        fight(p, d, dungeater, sc);
        System.out.println("With that out of the way, you see two branching paths in the rubble of the fight.");
        System.out.println("One leads to a ringed temple, and the other to a massive checkered field.");
        System.out.println(p.getName() + ", which path will you go for? TBD!");
    }

    public static void fight(Player p, Dice d, Enemy e, Scanner sc) {
        int roll, playerdamage, enemydamage;
        Random r = new Random();
        if (sc.next().equals("roll")) {
            roll = d.roll();
            System.out.println(d.toString());
            if (roll <= 10) {
                System.out.println("You attacked, but the enemy moved out of the way in time!");
                enemydamage = r.nextInt(e.getDamage());
                System.out.println("The enemy attacked, dealing " + enemydamage + " damage!");
                p.reduceHp(enemydamage);
                System.out.println("You now have " + p.getHp() + " HP");
                if (p.getHp() > 0) {
                    System.out.println("Type 'roll' to go again!");
                    fight(p, d, e, sc);
                }
            }
            if (p.getHp() < 0) {
                System.out.println("You have dieded! Your journey ends here...");
                System.exit(1);
            }
            if (roll > 10) {
                System.out.println("You attacked, and the enemy was directly hit!");
                playerdamage = r.nextInt(e.getHp()) + 10;
                System.out.println("The attack dealt " + playerdamage + " damage!");
                e.reduceHp(playerdamage);
                System.out.println("Enemy now has " + e.getHp() + " HP");
                if (e.getHp() > 0) {
                    System.out.println("Type 'roll' to go again!");
                    fight(p, d, e, sc);
                }

            }

        } else if (!sc.next().equals("roll")) {
            System.out.println("Error: invalid command, restarting battle sequence");
            fight(p, d, e, sc);
        }
        if (e.getHp() < 0) {
            System.out.println("You have successfully taken down the " + e.getName() + ". Just another step forward!");
            endFight(p, e, r);
        }
    }

    public static void endFight(Player p, Enemy e, Random r) {
        int gains = r.nextInt(e.getDamage());
        p.setGold(gains);
        System.out.println("You now have " + p.getGold() + " gold");
        return;
    }
}
