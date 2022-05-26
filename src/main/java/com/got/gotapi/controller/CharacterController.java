package com.got.gotapi.controller;

import com.got.gotapi.model.Character;
import com.got.gotapi.service.CharacterService;
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
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping()
    public List<Character> getAllCharacters(@RequestParam(required = false) Map<String, String> queryParams) {
        return characterService.getAllCharacters(queryParams);
    }

    @GetMapping("/{id}")
    public Character getCharacterById(@PathVariable("id") int id) {
        return characterService.getCharacterById(id);
    }
}
