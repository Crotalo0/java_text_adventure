package com.textadventure.entities;

public class Player extends CharactersEntity{

    public Player(String name) {
        this.setName(name);
        this.setMaxHp(100);
        this.setHp(100);
        this.setDmg(10+Weapons.getWeaponDamage());
    }

    @Override
    public void printStats() {
        System.out.printf("I am %s and i have %d/%d hp and i have %d damage!%n",
                this.getName(), this.getHp(), this.getMaxHp(), this.getDmg());
    }
}
