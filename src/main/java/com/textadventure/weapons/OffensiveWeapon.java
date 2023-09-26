package com.textadventure.weapons;

import com.textadventure.characters.CharacterEntity;

public class OffensiveWeapon extends WeaponEntity{

    private int SELF_DMG = 5;
    private int DMG_BOOST = 5;
    public OffensiveWeapon() {
        this.setName("Mauro's Big D");
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
