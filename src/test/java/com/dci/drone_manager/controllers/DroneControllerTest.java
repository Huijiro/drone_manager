package com.dci.drone_manager.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.dci.drone_manager.models.Drone;
import com.dci.drone_manager.repository.DroneRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class DroneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DroneRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void testAll() throws Exception {
        repository.save(new Drone("Drone 1"));

        mockMvc.perform(get("/drone/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].nome").value("Drone 1"));
    }

    @Test
    void testCreate() throws Exception {
        mockMvc.perform(post("/drone/create"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    void testDelete() throws Exception {
        Drone testDrone = repository.save(new Drone("Drone 1"));

        mockMvc.perform(delete("/drone/delete/" + testDrone.getId()))
                .andExpect(status().isOk());

    }

    @Test
    void testGetById() throws Exception {
        Drone testDrone = repository.save(new Drone("Drone 1"));

        mockMvc.perform(get("/drone/" + testDrone.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.nome").value("Drone 1"));
    }

    @Test
    void testUpdate() throws Exception {
        Drone testDrone = repository.save(new Drone("Drone 1"));

        mockMvc.perform(patch("/drone/update/" + testDrone.getId())
                .contentType("application/json")
                .content("{\"nome\": \"Drone 2\"}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.nome").value("Drone 2"));
    }
}
