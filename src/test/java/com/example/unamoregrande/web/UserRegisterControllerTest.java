package com.example.unamoregrande.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class UserRegisterControllerTest {

    @Autowired
    private MockMvc mockMvc;


//    @Test
//    void testOpenRegisterForm() throws Exception {
//        mockMvc
//                .perform(get("/users/register"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("register"));
//    }
}