package com.textadventure.characters.entities;

import com.textadventure.weapons.entities.WeaponEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class CharacterEntity {

    protected ArrayList<Integer> dmg = new ArrayList<>(Arrays.asList(0, 0));
    protected WeaponEntity weapon;
    protected Random r = new Random();
    private String name;
    private Integer hp;
    private Integer maxHp;

    public boolean isAlive() {
        return hp > 0;
    }

    public void printStats() {
        System.out.printf("I am %s and i have %d/%d hp and i have %d/%d damage!%n",
                this.getName(), this.getHp(), this.getMaxHp(), dmg.get(0), dmg.get(1));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(Integer maxHp) {
        this.maxHp = maxHp;
    }

    public List<Integer> getDmg() {
        return dmg;
    }

    public void setDmg(int min, int max) {
        dmg.set(0, min);
        dmg.set(1, max);
    }

    public WeaponEntity getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponEntity weapon) {
        System.out.printf("-action: Weapon '%s' Equipped!%n", weapon.getName());
        this.weapon = weapon;
        this.updateDmg();
    }

    public void updateDmg() {
        this.setDmg(dmg.get(0) + weapon.getMinDmg(), dmg.get(1) + weapon.getMaxDmg());
    }

    public int attackLogic(CharacterEntity character) {
        // Get random number from min and max
        int damage = dmg.get(0) + r.nextInt(dmg.get(1) - dmg.get(0)) + 1;
        character.setHp((character.getHp() - damage));
        return damage;
    }
}
