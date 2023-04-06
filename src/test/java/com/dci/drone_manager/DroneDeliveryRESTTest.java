package com.dci.drone_manager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DroneDeliveryRESTTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createDrone() throws Exception {
        this.mockMvc.perform(post("/delivery/create")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void allDrone() throws Exception {
        this.mockMvc.perform(post("/delivery/all")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getByIdDrone() throws Exception {
        this.mockMvc.perform(post("/delivery/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void updateDrone() throws Exception {
        this.mockMvc.perform(post("/delivery/update/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void deleteDrone() throws Exception {
        this.mockMvc.perform(post("/delivery/delete/1")).andDo(print()).andExpect(status().isOk());
    }
}
