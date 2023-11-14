package com.textadventure.eastereggs;

import com.textadventure.commands.entities.CommandEntity;

public class EdoEgg extends CommandEntity {
    // Primo Singleton Rick
    private static EdoEgg instance;
    public static EdoEgg getInstance() {
        if (null == instance) {
            instance = new EdoEgg();
        }
        return instance;
    }


    public void execute(String... attribute) {
        //mi piacciono i draghi e le montagne in corsivo
        System.out.println("\uD835\uDCC2\uD835\uDCBE \uD835\uDCC5\uD835\uDCBE\uD835\uDCB6\uD835\uDCB8\uD835\uDCB8\uD835\uDCBE\uD835\uDC5C\uD835\uDCC3\uD835\uDC5C \uD835\uDCBE \uD835\uDCB9\uD835\uDCC7\uD835\uDCB6\uD835\uDC54\uD835\uDCBD\uD835\uDCBE \uD835\uDC52 \uD835\uDCC1\uD835\uDC52 \uD835\uDCC2\uD835\uDC5C\uD835\uDCC3\uD835\uDCC9\uD835\uDCB6\uD835\uDC54\uD835\uDCC3\uD835\uDC52");
    }
}
