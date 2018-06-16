package za.co.tamboer.tamboerblack11.player.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.tamboer.tamboerblack11.player.Player;
import za.co.tamboer.tamboerblack11.player.PlayerService;
import za.co.tamboer.tamboerblack11.player.fixtures.PlayerFixtures;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {

    /*
    Another useful approach is to not start the server at all,
    but test only the layer below that,
    where Spring handles the incoming HTTP request
    and hands it off to your controller.
    That way, almost the full stack is used,
    and your code will be called exactly the same way
    as if it was processing a real HTTP request,
    but without the cost of starting the server.
    To do that we will use Spring’s MockMvc,
    and we can ask for that to be injected for us
    by using the @AutoConfigureMockMvc annotation on the test case:
    */

    @Mock
    private PlayerService service;

    @InjectMocks
    private PlayerController controller;

    @Test
    public void getPlayers() throws Exception {

        List<Player> players = PlayerFixtures.playersTDH();
        when(service.getPlayers()).thenReturn(players);

        ResponseEntity responseEntity =
                controller.getPlayers();

        verify(service).getPlayers();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(players);

    }

    @Test
    public void getPlayer() throws Exception {

        Player player = PlayerFixtures.tom();
        when(service.getPlayer(1L)).thenReturn(player);

        ResponseEntity responseEntity =
                controller.getPlayer(1L);

        verify(service).getPlayer(1L);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(player);
    }

    @Test
    public void getNotExistingPlayerShouldReturn404() throws Exception {

        Player player = PlayerFixtures.tom();
        when(service.getPlayer(1L)).thenReturn(null);

        ResponseEntity responseEntity =
                controller.getPlayer(1L);

        verify(service).getPlayer(1L);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(responseEntity.getBody()).isNull();
    }
}