package com.textadventure.entities;

public abstract class Weapons extends CharactersEntity {


    private String weaponName = "No weapon";
    private static int weaponDamage;

    public void startingMelee () {
        this.weaponName = "Sword";
        this.weaponDamage = 2;
    }

    public void startingRanged () {
        this.weaponName = "Bow";
        this.weaponDamage = 2;
    }

    public void customWeapon (String weaponName, int weaponDamage) {
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
    }

    // Getter and Setter
    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public static int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}
