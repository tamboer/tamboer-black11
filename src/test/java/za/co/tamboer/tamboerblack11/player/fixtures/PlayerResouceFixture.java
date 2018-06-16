package za.co.tamboer.tamboerblack11.player.fixtures;

import za.co.tamboer.tamboerblack11.player.web.PlayerResource;

public class PlayerResouceFixture {

    public static PlayerResource bob() {
        PlayerResource playerResource = new PlayerResource();
        playerResource.setUsername("bob55");
        playerResource.setEmail("bob@example.com");
        playerResource.setName("Bob");
        playerResource.setAlias("Bobby");
        playerResource.setAge(55);
        playerResource.setGender("male");
        return playerResource;
    }
}
