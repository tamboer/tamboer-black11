package za.co.tamboer.tamboerblack11.player.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PlayerService service;

    @InjectMocks
    private PlayerController controller;

    @Test
    public void getPlayers() throws Exception {

        List<Player> players = PlayerFixtures.playersTDH();
        when(service.getPlayers()).thenReturn(players);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(PlayerUrl.BASE_URL)
                .accept(
                        MediaType.APPLICATION_JSON);;

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        ResponseEntity responseEntity =
                controller.getPlayers();

        verify(service).getPlayers();
        System.out.println(result.getResponse());
        assertThat(result).isNotNull();
        assertThat(result.getResponse().getContentAsString()).isNotNull();
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(players);


//        JSONAssert.assertEquals(expected, result.getResponse()
//                .getContentAsString(), false);

    }

    private String expected(){
        return "Player {id=null, username='tom55', email='tom@example.com', name='Tom Fool', alias='Tommy', age=55, gender='male'},\n" +
                "    Player{id=null, username='dick55', email='dick@example.com', name='Dick Fool', alias='Dicky', age=55, gender='male'},\n" +
                "    Player{id=null, username='harry55', email='harry@example.com', name='Harry Fool', alias='Arrrrr', age=55, gender='male'}]";
    }
    private String getBody() {
        return  "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"username\": \"Bob\",\n" +
                "        \"email\": \"bob@example.com\",\n" +
                "        \"name\": \"Bob Nelson\",\n" +
                "        \"alias\": \"Bob\",\n" +
                "        \"age\": 55,\n" +
                "        \"gender\": \"male\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"username\": \"Joe\",\n" +
                "        \"email\": \"joe@example.com\",\n" +
                "        \"name\": \"Joe Martin\",\n" +
                "        \"alias\": \"Joe\",\n" +
                "        \"age\": 55,\n" +
                "        \"gender\": \"male\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 3,\n" +
                "        \"username\": \"Alf\",\n" +
                "        \"email\": \"alf@example.com\",\n" +
                "        \"name\": \"Alf Smith\",\n" +
                "        \"alias\": \"Alf\",\n" +
                "        \"age\": 55,\n" +
                "        \"gender\": \"male\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 4,\n" +
                "        \"username\": \"Jan\",\n" +
                "        \"email\": \"jan@example.com\",\n" +
                "        \"name\": \"Jan Olaf\",\n" +
                "        \"alias\": \"Jan\",\n" +
                "        \"age\": 55,\n" +
                "        \"gender\": \"male\"\n" +
                "    }\n" +
                "]";
    }
}