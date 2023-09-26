package com.textadventure.weapons;

import com.textadventure.characters.CharacterEntity;

public abstract class WeaponEntity {

    private String name;
    private Integer minDmg;
    private Integer maxDmg;

    public abstract void superAttack(CharacterEntity user, CharacterEntity enemy);


    // Getter and Setter
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Integer getMinDmg() {return minDmg;}
    public void setMinDmg(Integer minDmg) {this.minDmg = minDmg;}
    public Integer getMaxDmg() {return maxDmg;}
    public void setMaxDmg(Integer maxDmg) {this.maxDmg = maxDmg;}
}
