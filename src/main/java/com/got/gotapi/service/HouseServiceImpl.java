package com.got.gotapi.service;

import com.got.gotapi.feign.GotFeignClient;
import com.got.gotapi.model.House;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class HouseServiceImpl implements HouseService{

    private final GotFeignClient gotFeignClient;

    @Override
    public List<House> getAllHouses(Map<String, String> queryParams) {
        log.debug("Get all houses");

        return gotFeignClient.getAllHouses(queryParams);
    }

    @Override
    public House getHouseById(int id) {
        log.info("Get house by id: {}", id);

        return gotFeignClient.getHouseById(id);
    }
}
