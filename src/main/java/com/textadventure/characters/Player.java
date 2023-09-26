package com.textadventure.characters;

public class Player extends CharacterEntity {

    // WE WILL EXTEND TO OTHER CHARACTERS LATER
    private Integer superAttackLimiter = 0;

    public Player(String name) {
        this.setName(name);
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

        } else {
            System.out.println("SuperAttack not charged! Use more normal attack!");
        }

    }
}