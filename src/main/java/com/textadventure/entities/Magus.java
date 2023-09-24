package com.textadventure.entities;

public class Magus extends CharactersEntity{

    public Magus() {
        this.setName("Magus");
        this.setMaxHp(40);
        this.setHp(40);
        this.setDmg(3);
    }

    public void printStats() {
        System.out.printf("I am %s and i have %d/%d hp and i have %d damage!%n",
                this.getName(), this.getHp(), this.getMaxHp(), this.getDmg());
    }
}
