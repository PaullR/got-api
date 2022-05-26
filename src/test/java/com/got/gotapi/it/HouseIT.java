package com.got.gotapi.it;

import com.got.gotapi.TestUtils;
import com.got.gotapi.model.House;
import com.got.gotapi.service.HouseService;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HouseIT {
        @Autowired
        private HouseService service;

        @Test
        public void whenSpringContextIsBootstrapped_thenNoExceptions() {
        }

        @Test
        public void whenGetAllCharacters_thenAllCharactersArePresent() {


            List<House> allHouses = service.getAllHouses(new HashMap<>());

            assertFalse(allHouses.isEmpty());
        }

        @Test
        public void getFirstThreeHouses() {
            HashMap<String, String> pagination = new HashMap<>();
            pagination.put("page", "1");
            pagination.put("pageSize", "3");

            List<House> houses = service.getAllHouses(pagination);

            assertEquals(3, houses.size());
        }

        @Test
        public void filterHousesByName() {
            String houseName = "House Algood";

            HashMap<String, String> pagination = new HashMap<>();
            pagination.put("name", houseName);

            List<House> houses = service.getAllHouses(pagination);

            assertEquals(1, houses.size());
            assertEquals(houses.get(0).getName(), houseName);
        }


        @Test
        public void whenGetHouseByExistentId_thenHouseExists() {

            House expectedHouse = TestUtils.getFirstHouse();
            House actualHouse = service.getHouseById(1);

            assertNotNull(actualHouse);
            assertEquals(actualHouse.getName(), expectedHouse.getName());
        }

        @Test
        public void whenGetHouseByNonExistentId_exceptionThrown() {

            assertThrows(FeignException.class, () -> service.getHouseById(12345));
        }
}
