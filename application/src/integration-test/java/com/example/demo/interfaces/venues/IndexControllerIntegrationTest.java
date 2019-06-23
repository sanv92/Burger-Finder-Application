package com.example.demo.interfaces.venues;

import com.example.demo.ControllerIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerIntegrationTest extends ControllerIntegrationTest {

    @Test
    void index() {
        ResponseEntity<String> response = restTemplate
                .getForEntity("/", String.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void testHomePage() throws Exception {
        this.mockMvc.perform(
                get("/")
        )
                .andExpect(status().isOk())
                .andExpect(view().name("index"));

    }
}