package za.co.tamboer.tamboerblack11.player.web;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.tamboer.tamboerblack11.TamboerBlack11Application;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TamboerBlack11Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControllerItTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Before
    public void setUp() throws Exception {
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createPlayer()  {
    }

    @Test
    public void getPlayer() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/players/1"),
                HttpMethod.GET, entity, String.class);

        String expected = "{id:1,name:'Bob Nelson',age:55,alias:'Bob',email:'bob@example.com',gender:'male',username:'Bob'}";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void getPlayers() {
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}