package com.got.gotapi.service;

import com.got.gotapi.feign.GotFeignClient;
import com.got.gotapi.model.Character;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CharacterServiceImpl implements CharacterService{

    @Autowired
    private final GotFeignClient gotFeignClient;

    @Override
    public List<Character> getAllCharacters(Map<String, String> queryParams) {
        log.debug("Get all characters");

        return gotFeignClient.getAllCharacters(queryParams);
    }

    @Override
    public Character getCharacterById(int id) {
        log.info("Get character by id: {}", id);

        return gotFeignClient.getCharacterById(id);
    }
}