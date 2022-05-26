package com.got.gotapi.service;

import java.util.List;
import java.util.Map;

import com.got.gotapi.model.Character;

public interface CharacterService {
    public List<Character> getAllCharacters(Map<String, String> queryParams);

    public Character getCharacterById(int id);
}