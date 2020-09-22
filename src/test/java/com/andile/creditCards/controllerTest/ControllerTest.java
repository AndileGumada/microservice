package com.andile.creditCards.controllerTest;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
public class ControllerTest {

    //
    @Autowired
    MockMvc mockMvc;

//    public void test200Ok() throws Exception {
//            String name = "Thabile";
//            int creditScore = 500;
//
//            mockMvc.perform(
//                    post("v1/cards")
//                    .param(name)
//                    //.params(creditScore)
//
//            ).andExpect(
//                    status().isOk()
//            ).andExpect(
//                    //content().string(containsString())
//            );

   // }
}
