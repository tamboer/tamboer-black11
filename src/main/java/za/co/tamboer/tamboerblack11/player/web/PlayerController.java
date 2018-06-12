package za.co.tamboer.tamboerblack11.player.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import za.co.tamboer.tamboerblack11.player.Player;
import za.co.tamboer.tamboerblack11.player.PlayerService;
import za.co.tamboer.tamboerblack11.player.web.converter.PlayerResourceReader;

import java.util.List;


@Controller
@RequestMapping(PlayerUrl.BASE_URL)
public class PlayerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerController.class);

    private final PlayerService playerService;
    private final PlayerResourceReader playerResourceReader;

    public PlayerController(final PlayerService playerService) {
        this.playerService = playerService;
        this.playerResourceReader = new PlayerResourceReader();
    }

    @PostMapping(produces = {PlayerUrl.PLAYER_JSON_V1, "text/plain", "application/*", "*", "*/*"})
    public ResponseEntity<Void> createPlayer(
            @Validated @RequestBody final PlayerResource resource) {

        final Player player = playerService.createPlayer(
                playerResourceReader.read(resource));

        return ResponseEntity.status(HttpStatus.CREATED)
                .location(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(player.getId())
                        .toUri())
                .build();

    }

    @GetMapping(path = "/{id}",produces = {PlayerUrl.PLAYER_JSON_V1, "text/plain", "application/*", "*", "*/*"})
    public ResponseEntity getPlayer(@PathVariable Long id) {

        ResponseEntity responseEntity = ResponseEntity.notFound().build();

        Player player = playerService.getPlayer(id);
        if (player != null)responseEntity = ResponseEntity.ok(player);

        return	responseEntity;

    }

    @GetMapping(produces = {PlayerUrl.PLAYER_JSON_V1, "text/plain", "application/*", "*", "*/*"})
    public ResponseEntity getPlayers() {

        ResponseEntity responseEntity = ResponseEntity.notFound().build();

        List<Player> players = playerService.getPlayers();
        if (players != null)responseEntity = ResponseEntity.ok(players);

        return	responseEntity;

    }


}
