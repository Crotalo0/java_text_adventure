package com.textadventure.weapons;

import com.textadventure.characters.CharacterEntity;
import com.textadventure.characters.Player;

public class DefensiveWeapon extends WeaponEntity {

    private static final int HEAL_PERCENTAGE = 33;

    public DefensiveWeapon() {
        this.setMaxDmg(3);
        this.setMinDmg(1);
        this.setName("Defensive Sword");
        this.setCooldown(2);
    }

    public void ability(CharacterEntity user, CharacterEntity enemy) {
        // Next attack heals based on damage
        System.out.println("Using ability: " + this.getName());
        int damage = Player.getInstance().attack(enemy);
        int heal = damage * HEAL_PERCENTAGE / 100;
        user.setHp(user.getHp() + heal);
        System.out.printf("%s heals for %d hp\n", Player.getInstance().getName(), heal);
    }
}
