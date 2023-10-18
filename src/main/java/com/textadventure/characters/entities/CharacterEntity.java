package com.textadventure.characters.entities;

import com.textadventure.weapons.entities.WeaponEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class CharacterEntity {

    private String name;
    private Integer hp;
    private Integer maxHp;
    protected ArrayList<Integer> dmg = new ArrayList<>(Arrays.asList(0, 0));
    protected WeaponEntity weapon;
    protected Random r = new Random();

    public void printStats() {
        System.out.printf("I am %s and i have %d/%d hp and i have %d/%d damage!%n",
                this.getName(), this.getHp(), this.getMaxHp(), dmg.get(0), dmg.get(1));
    }

    // Getter and Setter
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Integer getHp() {return hp;}
    // TODO: implement death
    public void setHp(Integer hp) {this.hp = hp;}
    public Integer getMaxHp() {return maxHp;}
    public void setMaxHp(Integer maxHp) {this.maxHp = maxHp;}
    public ArrayList<Integer> getDmg() {
        return dmg;
    }
    public void setDmg(int min, int max) {
        dmg.set(0, min);
        dmg.set(1, max);
    }
    public WeaponEntity getWeapon() {return weapon;}
    public void setWeapon(WeaponEntity weapon) {
        System.out.printf("Weapon '%s' Equipped!%n", weapon.getName());
        this.weapon = weapon;
        this.updateDmg();
    }
    public void updateDmg() {
        this.setDmg(dmg.get(0) + weapon.getMinDmg(), dmg.get(1) + weapon.getMaxDmg());
    }
    public int attackLogic(CharacterEntity character) {
        // Get random number from min and max
        int damage = dmg.get(0) + r.nextInt(dmg.get(1)-dmg.get(0)) + 1;
        character.setHp((character.getHp() - damage));
        return damage;
    }
}
