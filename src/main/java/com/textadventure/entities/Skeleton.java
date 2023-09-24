package com.textadventure.entities;

public class Skeleton extends CharactersEntity{

    public Skeleton() {
        this.setName("Skeleton");
        this.setMaxHp(40);
        this.setHp(40);
        this.setDmg(3);
    }

    public void printStats() {
        System.out.printf("I am %s and i have %d/%d hp and i have %d damage!%n",
                this.getName(), this.getHp(), this.getMaxHp(), this.getDmg());
    }
    public void attack(Player player) {
        System.out.println("Skeleton throw an arrow to " + player.getName());
        player.setHp(player.getHp() - getDmg());

    }
}

