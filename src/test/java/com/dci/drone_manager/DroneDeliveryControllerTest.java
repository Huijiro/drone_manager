package com.dci.drone_manager;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dci.drone_manager.controllers.DroneDeliveryController;

@SpringBootTest
public class DroneDeliveryControllerTest {
    @Autowired
    private DroneDeliveryController controller;

    @Test
    void controllerExists() {
        assertThat(controller).isNotNull();
    }

    @Test
    void createExists() {
        assertThat(controller.create()).isNotNull();
    }

    @Test
    void allExists() {
        assertThat(controller.all()).isNotNull();
    }

    @Test
    void getByIdExists() {
        assertThat(controller.getById()).isNotNull();
    }

    @Test
    void updateExists() {
        assertThat(controller.update()).isNotNull();
    }

    @Test
    void deleteExists() {
        assertThat(controller.delete()).isNotNull();
    }
}
