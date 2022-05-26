package com.got.gotapi.controller;

import com.got.gotapi.model.House;
import com.got.gotapi.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/houses")
public class HouseController {

    private final HouseService houseService;

    @GetMapping()
    public List<House> getAllHouses(@RequestParam(required = false) Map<String, String> queryParams) {
        return houseService.getAllHouses(queryParams);
    }

    @GetMapping("/{id}")
    public House getHouseById(@PathVariable("id") int id) {
        return houseService.getHouseById(id);
    }
}
