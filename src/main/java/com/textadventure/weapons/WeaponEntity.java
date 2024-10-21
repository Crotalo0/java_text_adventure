package com.textadventure.weapons;

import com.textadventure.characters.CharacterEntity;
import lombok.Data;

@Data
public abstract class WeaponEntity {

    private String name;
    private Integer minDmg;
    private Integer maxDmg;
    private Integer cooldown;

    public abstract void ability(CharacterEntity user, CharacterEntity enemy);
}
