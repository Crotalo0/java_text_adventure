package com.textadventure.characters.enemies;

import com.textadventure.characters.entities.CharacterEntity;

public class Skeleton extends CharacterEntity {

    // TODO: add enemy counter and name them accordingly
    // TODO: Add weapon to enemies
    public Skeleton(String name) {
        this.setName(name);
        this.setMaxHp(40);
        this.setHp(40);
        this.setDmg(1, 8);
    }

    public static CharacterEntity create(String name) {
        return new Skeleton(name);
    }

    public void attack(CharacterEntity player) {
        int damage = this.attackLogic(player);
        System.out.println("Skeleton throw an arrow to " + player.getName() + "deals " + damage + " damage");

    }
}

