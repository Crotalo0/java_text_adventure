package textadventure.chapters;

import textadventure.characters.Player;
import textadventure.characters.Skeleton;
import textadventure.map.MapCreator;
import textadventure.status.GameState;

import java.util.Arrays;
import java.util.Map;

public class Chapter1 {
    private Player player;

    public Chapter1(Player player) {
        this.player = player;
    }

    public void start() {
        MapCreator map = new MapCreator(3,3);
        GameState gameState = new GameState();
        Skeleton skeleton = new Skeleton();
        map.filler();
        map.printer();
        player.printStats();
        skeleton.printStats();

        gameState.setPlayerPosition(new int[] {0,0});
        int[] posTestInit = gameState.getPlayerPosition();
        System.out.printf("Initial position -- x: %d, y: %d\n",posTestInit[0], posTestInit[1]);

        player.moveTo(new int[] {0,1}, map, gameState);
        int[] posTest = gameState.getPlayerPosition();
        System.out.printf("After position -- x: %d, y: %d\n",posTest[0], posTest[1]);



    }

}
