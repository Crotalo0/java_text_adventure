package com.textadventure.texts;

// TODO: In future text will be stored on markdown or txt files and this class will take those files and return them
// TODO: we will see how to change it when the time comes
public class TextLoader {
    public static final String WELCOME = """
            Greetings, brave soul, and welcome to realms untold.
            Embark on a journey where mystic lands await your footfall,
            and ancient secrets whisper in the wind. Ready thyself for a tale
            woven by destiny, where magic and adventure entwine. May your presence
            bring light to these enchanted realms.
            """;

    private TextLoader() {
        throw new IllegalStateException("Utility Class to store text");
    }
}
