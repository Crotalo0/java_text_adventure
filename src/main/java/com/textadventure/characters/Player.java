package com.textadventure.characters;

import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.utils.ScannerSingleton;
import com.textadventure.weapons.DefensiveWeapon;
import com.textadventure.weapons.OffensiveWeapon;
import com.textadventure.weapons.entities.WeaponEntity;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Player extends CharacterEntity {

    // Pattern singleton
    private static Player instance;
    public static Player getInstance() {
        if (null == instance) {
            instance = new Player();
        }
        return instance;
    }


    // TODO: WE WILL EXTEND TO OTHER CHARACTERS LATER
    private Integer superAttackLimiter = 0;

    public Player() {
        this.setMaxHp(100);
        this.setHp(100);
        this.setDmg(8, 10);
        // Player inputs
        this.setPlayerName();
        this.setWeapon();
    }

    public void setPlayerName() {
        System.out.print("What be thy name, lone wanderer? ");
        this.setName(ScannerSingleton.getInstance().nextLine());
    }

    public void setWeapon() {
        System.out.printf(
                "Now... %s..., with thy name no longer veiled, which weapon shall grace thy grasp...%n",
                getName());
        System.out.println("1. Offensive weapon");
        System.out.println("2. Defensive weapon");
        System.out.println("Select one: ");
        int choice = ScannerSingleton.getInstance().nextInt();
        WeaponEntity startingWeapon = (choice == 1) ? new OffensiveWeapon() : new DefensiveWeapon();
        this.setWeapon(startingWeapon);
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