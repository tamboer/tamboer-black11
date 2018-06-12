package za.co.tamboer.tamboerblack11.player;


import org.springframework.stereotype.Service;
import za.co.tamboer.tamboerblack11.player.persistence.PlayerRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player createPlayer(Player player) {

        if (player.getId() != null) {
            throw new RuntimeException("The player cannot have an id already");
        }
        validate(player);

        return save(player);
    }

    private Player save(Player player){
        return playerRepository.save(player);

    }


    private void validate(Player player) {

    }

    public Player getPlayer(Long playerId) {
        return playerRepository.findById(playerId).get();
    }

    public List<Player> getPlayers() {
        List<Player> list = new ArrayList<>();
        playerRepository.findAll().forEach(e -> list.add(e));
        return list;
    }
}
