package com.textadventure.characters;

import com.textadventure.characters.entities.CharacterEntity;

public class Skeleton extends CharacterEntity {

    public Skeleton(String name) {
        this.setName(name);
        this.setMaxHp(40);
        this.setHp(40);
        this.setDmg(1,8);
    }

    public void attack(CharacterEntity player) {
        int damage = this.attackLogic(player);
        System.out.println("Skeleton throw an arrow to " + player.getName() + "deals " + damage + " damage");

    }
}

