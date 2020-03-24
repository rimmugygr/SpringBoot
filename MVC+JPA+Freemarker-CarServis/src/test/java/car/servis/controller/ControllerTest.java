package car.servis.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@WebMvcTest(CommentsController.class)


class ControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void commentTest() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/comments/1"))
//                .andDo()
//                .andExpect();

    }



}