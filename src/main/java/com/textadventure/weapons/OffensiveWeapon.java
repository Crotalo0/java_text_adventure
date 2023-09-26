package com.textadventure.weapons;

import com.textadventure.characters.CharacterEntity;

public class OffensiveWeapon extends WeaponEntity{

    public OffensiveWeapon() {
        this.setName("Mauro's Big D");
        this.setMaxDmg(5);
        this.setMinDmg(1);
    }
    public void superAttack(CharacterEntity user, CharacterEntity enemy) {
        //TODO: Example, next attack consumes life but does more damage.
        int selfDmg = 5;
        int dmgBoost = 5;
        user.setHp(user.getHp()-selfDmg);
        user.setDmg(
                user.getDmg().get(0)+dmgBoost,
                user.getDmg().get(1)+dmgBoost
        );

    }
}
