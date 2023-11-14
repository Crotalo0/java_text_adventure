package com.textadventure.characters.enemies;

import com.textadventure.characters.entities.CharacterEntity;

public class BasicMonsters extends CharacterEntity {

    public static BasicMonsters createBlob() {
        BasicMonsters blob = new BasicMonsters();
        blob.setName("B(l)ob");
        blob.setMaxHp(20);
        blob.setHp(20);
        blob.setDmg(4, 8);
        return blob;
    }

    public static BasicMonsters createZombie() {
        BasicMonsters zombie = new BasicMonsters();
        zombie.setName("Edoardo");
        zombie.setMaxHp(30);
        zombie.setHp(30);
        zombie.setDmg(0, 1);
        return zombie;
    }
}
