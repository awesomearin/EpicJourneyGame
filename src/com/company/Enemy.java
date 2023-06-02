package com.company;

public class Enemy
{
    public String name;
    public int hp;
    public int damage;

    public Enemy(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void reduceHp(int damage) {
        hp = getHp() - damage;
        if (hp == 0) {
            System.out.println(getName() + " has fallen in battle!");
        }
    }

    public int getDamage() {
        return damage;
    }
}
