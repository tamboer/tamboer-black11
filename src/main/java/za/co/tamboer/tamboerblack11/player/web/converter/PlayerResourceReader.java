package za.co.tamboer.tamboerblack11.player.web.converter;

import za.co.tamboer.tamboerblack11.player.Player;
import za.co.tamboer.tamboerblack11.player.web.PlayerResource;

public class PlayerResourceReader {
    public Player read(final PlayerResource resource) {

        Player player = new Player();
        player.setId(resource.getId());
        player.setUsername(resource.getUsername());
        player.setEmail(resource.getEmail());
        player.setName(resource.getName());
        player.setAlias(resource.getAlias());
        player.setAge(resource.getAge());
        player.setGender(resource.getGender());

        return player;
    }
}
