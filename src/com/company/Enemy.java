package com.company;

public class Enemy
{
    public String name;
    public int hp;
    public int damage;

    public Enemy() {
        this.name = getName();
        this.hp = getHp();
        this.hp = getDamage();
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }
}
