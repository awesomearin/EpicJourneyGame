package com.company;

public class Player
{
    public String name;
    public int hp;
    public int gold;

    public Player() {
        this.name = getName();
        this.hp = 100;
        this.gold = 0;
    }

    public String getName() {
        return name;
    }

    public void setHp(int food) {
        hp = getHp() + food;
    }

    public int getHp() {
        return hp;
    }

    public void reduceHp(int damage) {
        hp = getHp() - damage;
        if (hp == 0) {
            System.out.println("You Died");
        }
    }

    public void setGold(int profit) {
        gold = getGold() + profit;
    }

    public int getGold() {
        return gold;
    }

    public void payUp(int cost) {
        if (gold == 0) {
            System.out.println("You Have No Money!");
        } else {
            gold = getGold() - cost;
        }
    }

    public String toString() {
        return "Your name is " + getName() + "\n You have " + getHp() + " HP \n You have " + getGold() + " gold";
    }
}
