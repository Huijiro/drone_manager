package com.dci.drone_manager.controllers;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.dci.drone_manager.models.Delivery;
import com.dci.drone_manager.models.Drone;
import com.dci.drone_manager.repository.DeliveryRepository;
import com.dci.drone_manager.repository.DroneRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DeliveryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private DeliveryRepository repository;

    @Autowired
    private DroneRepository droneRepository;

    @BeforeEach
    void setUp() {
        droneRepository.save(new Drone("Drone 1"));
        droneRepository.save(new Drone("Drone 2"));
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
        droneRepository.deleteAll();
    }

    @Test
    void testAll() throws Exception {
        Delivery delivery = new Delivery();
        delivery.setDrone(droneRepository.findAll().get(0));
        repository.save(delivery);

        // Check if the delivery is in the list
        mockMvc.perform(get("/delivery/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(delivery.getId()));
    }

    @Test
    void testCreate() throws Exception {
        mockMvc.perform(post("/delivery/create")
                .param("longitude", "40.32")
                .param("latitude", "40.32")).andExpect(status().isOk());

    }

    @Test
    void testRecebido() throws Exception {
        Delivery delivery = new Delivery();
        delivery.setDrone(droneRepository.findAll().get(0));
        repository.save(delivery);

        mockMvc.perform(patch("/delivery/recebido/" + delivery.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.entregue").value(true));
    }
}
