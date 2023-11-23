package com.textadventure.weapons;

import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.weapons.entities.WeaponEntity;

public class OffensiveWeapon extends WeaponEntity {

    private static final int DMG_BOOST = 50;

    public OffensiveWeapon() {
        this.setName("Aggressive sword");
        this.setMaxDmg(5);
        this.setMinDmg(1);
        this.setCooldown(3);
    }

    public void superAttack(CharacterEntity user, CharacterEntity enemy) {
        // Next attack consumes life but does more damage.
        int selfDamage = 50;
        user.setHp(user.getHp() - selfDamage);
        user.setDmg(
                user.getDmg().get(0) + DMG_BOOST,
                user.getDmg().get(1) + DMG_BOOST
        );
    }

    public void revertSuperAttack(CharacterEntity user) {
        // Util method used to restore normal damage
        user.setDmg(
                user.getDmg().get(0) - DMG_BOOST,
                user.getDmg().get(1) - DMG_BOOST
        );
    }
}
