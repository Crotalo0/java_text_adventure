package com.textadventure.weapons;

import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.weapons.entities.WeaponEntity;

public class DefensiveWeapon extends WeaponEntity {

    public DefensiveWeapon() {
        this.setMaxDmg(3);
        this.setMinDmg(1);
        this.setName("Defensive Sword");
    }
    public void superAttack(CharacterEntity user, CharacterEntity enemy) {
        // TODO
        System.out.println("TODO");
    }
    public void revertSuperAttack(CharacterEntity user) {
        System.out.println("TODO");
    }
}
