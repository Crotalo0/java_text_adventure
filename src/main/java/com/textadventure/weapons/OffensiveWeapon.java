package com.textadventure.weapons;

import com.textadventure.characters.CharacterEntity;
import com.textadventure.characters.Player;

public class OffensiveWeapon extends WeaponEntity {

    private static final int DMG_BOOST = 50;

    public OffensiveWeapon() {
        this.setName("Aggressive sword");
        this.setMaxDmg(5);
        this.setMinDmg(1);
        this.setCooldown(3);
    }

    public void ability(CharacterEntity user, CharacterEntity enemy) {
        // Next attack consumes life but does more damage.
        System.out.println("Using ability: " + this.getName());
        int selfDamage = 40;
        user.setHp(user.getHp() - selfDamage);
        user.setDmg(
                user.getDmg().get(0) + DMG_BOOST,
                user.getDmg().get(1) + DMG_BOOST
        );
        Player.getInstance().attack(enemy);
        user.setDmg(
                user.getDmg().get(0) - DMG_BOOST,
                user.getDmg().get(1) - DMG_BOOST
        );

    }
}
