package com.got.gotapi.controller;

import com.got.gotapi.TestUtils;
import com.got.gotapi.service.HouseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HouseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HouseService houseService;

    @Test
    public void testGetHouseBydId() throws Exception {
        when(houseService.getHouseById(anyInt())).thenReturn(TestUtils.getFirstHouse());

        mockMvc.perform(get("/houses/1")
                        .content(TestUtils.asJsonString(TestUtils.getFirstHouse()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetAllHouses() throws Exception {
        when(houseService.getAllHouses(anyMap())).thenReturn(TestUtils.getHouseList());

        mockMvc.perform(get("/houses")
                        .content(TestUtils.asJsonString(TestUtils.getHouseList()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", hasSize(TestUtils.getHouseList().size())));
    }

}
