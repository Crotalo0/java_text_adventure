package com.textadventure.characters;

public class Player extends CharacterEntity {

    public Player(String name) {
        this.setName(name);
        this.setMaxHp(100);
        this.setHp(100);
        this.setDmg(8, 10);
    }

    public void attack(CharacterEntity enemy) {
        int damage = this.attackLogic(enemy);
        System.out.printf("%s attacks %s, deals %d damage%n",this.getName(), enemy.getName(), damage);
    }

    public void superAttack(CharacterEntity enemy) {
        weapon.superAttack(this, enemy);

    }
}