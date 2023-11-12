package com.textadventure.weapons;

import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.weapons.entities.WeaponEntity;

public class OffensiveWeapon extends WeaponEntity {

    private int SELF_DMG = 50;
    private int DMG_BOOST = 50;
    public OffensiveWeapon() {
        this.setName("Aggressive sword");
        this.setMaxDmg(5);
        this.setMinDmg(1);
    }
    public void superAttack(CharacterEntity user, CharacterEntity enemy) {
        //TODO: Example, next attack consumes life but does more damage.
        user.setHp(user.getHp()-SELF_DMG);
        user.setDmg(
                user.getDmg().get(0)+DMG_BOOST,
                user.getDmg().get(1)+DMG_BOOST
        );

    }
    public void revertSuperAttack(CharacterEntity user) {
        user.setDmg(
                user.getDmg().get(0)-DMG_BOOST,
                user.getDmg().get(1)-DMG_BOOST
        );
    }
}
