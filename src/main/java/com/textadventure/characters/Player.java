package com.textadventure.characters;

import com.textadventure.characters.entities.CharacterEntity;

public class Player extends CharacterEntity {

    // Pattern singleton
    private static Player instance;
    public static Player getInstance() {
        if (instance == null) {
            instance = new Player();
        }
        return instance;
    }


    // TODO: WE WILL EXTEND TO OTHER CHARACTERS LATER
    private Integer superAttackLimiter = 0;

    public Player() {
        this.setName("Mario");
        this.setMaxHp(100);
        this.setHp(100);
        this.setDmg(8, 10);
    }

    public void attack(CharacterEntity enemy) {
        int damage = this.attackLogic(enemy);
        System.out.printf("%s attacks %s, deals %d damage%n",this.getName(), enemy.getName(), damage);
        superAttackLimiter++;
    }

    public void superAttack(CharacterEntity enemy) {
        if (superAttackLimiter >= 3) {
            weapon.superAttack(this, enemy);
            System.out.print("SuperAttack! ");
            this.attack(enemy);
            weapon.revertSuperAttack(this);
            superAttackLimiter = 0;
        } else {
            System.out.println("Ability not charged! Use more normal attack!");
        }
    }
}