package com.textadventure.weapons.entities;

import com.textadventure.characters.entities.CharacterEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class WeaponEntity {

    private String name;
    private Integer minDmg;
    private Integer maxDmg;
    private Integer cooldown;

    public abstract void superAttack(CharacterEntity user, CharacterEntity enemy);

    public abstract void revertSuperAttack(CharacterEntity user);

}
