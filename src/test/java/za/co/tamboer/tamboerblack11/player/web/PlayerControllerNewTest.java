package za.co.tamboer.tamboerblack11.player.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import za.co.tamboer.tamboerblack11.player.fixtures.PlayerResouceFixture;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = {TamboerBlack11Application.class})
@SpringBootTest
//@Import(SecurityConfig.class)
//@EnableAutoConfiguration(exclude = {
//        SecurityAutoConfiguration.class})
@AutoConfigureMockMvc(secure = false)
public class PlayerControllerNewTest {


    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    //@Transactional
    public void create() throws Exception {
        final ResultActions resultActions = mockMvc.perform(
                post(PlayerUrl.BASE_URL)
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(PlayerResouceFixture.bob())))
                .andExpect(status().isCreated());

        //expectSingleSuccess(resultActions);
        //verify(eventPublisher).deviceCreated(any(DeviceCreatedEvent.class));
        //verifyNoMoreInteractions(eventPublisher);
    }


    private void expectSingleSuccess(final ResultActions resultActions) throws Exception {
        resultActions.andExpect(jsonPath("$.deviceUploadStatuses", hasSize(1)))
                .andExpect(jsonPath("$.deviceUploadStatuses[0].deviceInternalId", is("987987")))
                .andExpect(jsonPath("$.deviceUploadStatuses[0].status", is("OK")))
                .andExpect(jsonPath("$.deviceUploadStatuses[0].errors", empty()));
    }


}

