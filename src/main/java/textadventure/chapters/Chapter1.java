package textadventure.chapters;

import textadventure.characters.Player;
import textadventure.characters.Skeleton;

public class Chapter1 {
    private Player player;

    public Chapter1(Player player) {
        this.player = player;
    }

    public void start() {
        Skeleton skeleton = new Skeleton();
        player.printStats();
        skeleton.printStats();
    }

}
