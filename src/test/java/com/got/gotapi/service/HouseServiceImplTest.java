package com.got.gotapi.service;

import com.got.gotapi.TestUtils;
import com.got.gotapi.feign.GotFeignClient;
import com.got.gotapi.model.House;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HouseServiceImplTest {

    @Mock
    private GotFeignClient gotFeignClient;

    @InjectMocks
    private HouseServiceImpl houseService;

    @Test
    public void testGetAllBooks() {
        List<House> houses = TestUtils.getHouseList();

        when(gotFeignClient.getAllHouses(anyMap())).thenReturn(houses);

        List<House> actualHouseList = houseService.getAllHouses(anyMap());

        assertEquals(houses.size(), actualHouseList.size());
        assertIterableEquals(houses, actualHouseList);
    }
    @Test
    public void testGetHouseById() {
        House house = TestUtils.getFirstHouse();

        when(gotFeignClient.getHouseById(anyInt())).thenReturn(house);

        House actualHouse = houseService.getHouseById(anyInt());

        assertEquals(house, actualHouse);
    }
}
