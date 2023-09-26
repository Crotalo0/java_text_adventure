package com.textadventure.weapons;

import com.textadventure.characters.CharacterEntity;

public class DefensiveWeapon extends WeaponEntity{

    public DefensiveWeapon() {
        this.setMaxDmg(3);
        this.setMinDmg(1);
        this.setName("Mauro's Small D");
    }
    public void superAttack(CharacterEntity user, CharacterEntity enemy) {
        //TODO: Example, next attack you lose half HP.
        System.out.println("TODO");
    }
    public void revertSuperAttack(CharacterEntity user) {
        System.out.println("TODO");
    }
}
