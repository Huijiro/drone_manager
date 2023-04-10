package com.dci.drone_manager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class DroneRESTTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void createDrone() throws Exception {
    this.mockMvc.perform(post("/drone/create")).andDo(print()).andExpect(status().isOk());

  }

  @Test
  public void allDrone() throws Exception {
    this.mockMvc.perform(get("/drone/all")).andDo(print()).andExpect(status().isOk());

  }

  @Test
  public void getByIdDrone() throws Exception {
    this.mockMvc.perform(get("/drone/1")).andDo(print()).andExpect(status().isOk());
  }

  @Test
  public void updateDrone() throws Exception {
    this.mockMvc.perform(patch("/drone/update/1")).andDo(print()).andExpect(status().isOk());
  }

  @Test
  public void deleteDrone() throws Exception {
    this.mockMvc.perform(delete("/drone/delete/1")).andDo(print()).andExpect(status().isOk());
  }
}
