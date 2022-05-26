package com.got.gotapi.service;

import com.got.gotapi.model.House;

import java.util.List;
import java.util.Map;

public interface HouseService {
    public List<House> getAllHouses(Map<String, String> queryParams);

    public House getHouseById(int id);
}
