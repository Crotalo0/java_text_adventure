package com.textadventure.weapons.entities;

import com.textadventure.characters.entities.CharacterEntity;

public abstract class WeaponEntity {

    private String name;
    private Integer minDmg;
    private Integer maxDmg;

    public abstract void superAttack(CharacterEntity user, CharacterEntity enemy);
    public abstract void revertSuperAttack(CharacterEntity user);


    // Getter and Setter
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Integer getMinDmg() {return minDmg;}
    public void setMinDmg(Integer minDmg) {this.minDmg = minDmg;}
    public Integer getMaxDmg() {return maxDmg;}
    public void setMaxDmg(Integer maxDmg) {this.maxDmg = maxDmg;}
}
