package com.textadventure.commands;

import com.textadventure.characters.CharacterEntity;
import com.textadventure.characters.Player;

public class Ability extends Attack {

    @Override
    protected void performAttack(CharacterEntity enemy) {
        Player.getInstance().ability(enemy);
    }
}
