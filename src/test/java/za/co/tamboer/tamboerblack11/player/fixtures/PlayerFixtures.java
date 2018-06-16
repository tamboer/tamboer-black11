package za.co.tamboer.tamboerblack11.player.fixtures;

import za.co.tamboer.tamboerblack11.player.Player;

import java.util.Arrays;
import java.util.List;

public class PlayerFixtures {

    public static Player tom(){
        return new Player(
                "tom55",
                "tom@example.com",
                "Tom Fool",
                 "Tommy",
                55,
                "male"
        );
    }

    public static Player dick(){
        return new Player(
                "dick55",
                "dick@example.com",
                "Dick Fool",
                 "Dicky",
                55,
                "male"
        );
    }

    public static Player harry(){
        return new Player(
                "harry55",
                "harry@example.com",
                "Harry Fool",
                 "Arrrrr",
                55,
                "male"
        );
    }

    public static List<Player> playersTDH(){
        return Arrays.asList(tom(),dick(),harry());
    }
}
