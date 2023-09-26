package com.textadventure.characters;

public class Skeleton extends CharacterEntity {

    public Skeleton() {
        this.setName("Skeleton");
        this.setMaxHp(40);
        this.setHp(40);
        this.setDmg(1,8);
    }

    public void attack(CharacterEntity player) {
        int damage = this.attackLogic(player);
        System.out.println("Skeleton throw an arrow to " + player.getName() + "deals " + damage);

    }
}

