package com.textadventure.characters;

import com.textadventure.weapons.WeaponEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@Data
public abstract class CharacterEntity {

    protected ArrayList<Integer> dmg = new ArrayList<>(Arrays.asList(0, 0));
    protected WeaponEntity weapon;
    protected Random r = new Random();
    private String name;
    private Integer hp;
    private Integer maxHp;

    public boolean isDead() {
        return hp <= 0;
    }

    public void printStats() {
        System.out.printf("I am %s and i have %d/%d hp and i have %d/%d damage!%n",
                this.getName(), this.getHp(), this.getMaxHp(), dmg.get(0), dmg.get(1));
    }

    public void setDmg(int min, int max) {
        dmg.set(0, min);
        dmg.set(1, max);
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
