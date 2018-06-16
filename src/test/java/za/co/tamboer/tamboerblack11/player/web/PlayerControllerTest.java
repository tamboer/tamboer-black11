package za.co.tamboer.tamboerblack11.player.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import za.co.tamboer.tamboerblack11.player.PlayerService;

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

    @MockBean
    private PlayerService service;

    @Test
    public void getPlayers() throws Exception {

    }
}