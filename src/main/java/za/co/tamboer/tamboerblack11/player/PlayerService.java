package za.co.tamboer.tamboerblack11.player;


import org.springframework.stereotype.Service;
import za.co.tamboer.tamboerblack11.player.exceptions.UserEmailExistsException;
import za.co.tamboer.tamboerblack11.player.exceptions.UsernameExistsException;
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
        if(getPlayerByUsername(player.getUsername()))
            throw new UsernameExistsException("This username exists " + player.getUsername());

        if(getPlayerByEmail(player.getEmail()))
            throw new UserEmailExistsException("This email exists " + player.getEmail());
    }

    private Boolean getPlayerByUsername(String username) {
        List<Player> players = new ArrayList<>();

        playerRepository.findAll().forEach(player -> players.add(player));

        boolean exists = players.stream().anyMatch(player -> player.getUsername().equals(username));

        return exists;
    }

    private Boolean getPlayerByEmail(String email) {
        List<Player> players = new ArrayList<>();

        playerRepository.findAll().forEach(player -> players.add(player));

        boolean exists = players.stream().anyMatch(player -> player.getEmail().equals(email));

        return exists;
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
