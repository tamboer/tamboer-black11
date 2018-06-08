package za.co.tamboer.tamboerblack11.player;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    public Player createPlayer(Player player) {

        if (player.getId() != null) {
            throw new RuntimeException("The player cannot have an id already");
        }
        validate(player);

        return save(player);
    }

    private Player save(Player player){
        // todo
        return null;
    }

    private void validate(Player player) {

    }

}
