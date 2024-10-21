package com.textadventure.commands;

import com.textadventure.characters.CharacterEntity;
import com.textadventure.characters.Player;
import com.textadventure.status.GameState;

import java.util.Set;

public class Attack extends CommandEntity {

    Set<CharacterEntity> enemies = GameState.getInstance().getEnemies();

    public Attack() {
        this.attributes = enemies.stream()
                .map(CharacterEntity::getName)
                .toList().toArray(new String[0]);
    }

    @Override
    public void execute(String... attribute) {
        if (!isValidAttribute(attribute[0]))
            System.out.println("Invalid enemy");
        CharacterEntity enemy = GameState.getInstance().findEnemyByName(attribute[0]);
        if (null == enemy)
            System.out.println("This enemy doesn't exist");
        performAttack(enemy);
    }

    protected void performAttack(CharacterEntity enemy) {
        Player.getInstance().attack(enemy);
    }
}
