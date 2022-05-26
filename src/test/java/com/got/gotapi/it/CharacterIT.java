package com.got.gotapi.it;

import com.got.gotapi.TestUtils;
import com.got.gotapi.service.CharacterService;
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

import com.got.gotapi.model.Character;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CharacterIT {

        @Autowired
        private CharacterService service;

        @Test
        public void whenSpringContextIsBootstrapped_thenNoExceptions() {
        }

        @Test
        public void whenGetAllCharacters_thenAllCharactersArePresent() {
            List<Character> allCharacters = service.getAllCharacters(new HashMap<>());

            assertFalse(allCharacters.isEmpty());
        }

        @Test
        public void getFirstThreeCharacters() {
            HashMap<String, String> pagination = new HashMap<>();
            pagination.put("page", "1");
            pagination.put("pageSize", "3");

            List<Character> characters = service.getAllCharacters(pagination);

            assertEquals(3, characters.size());
        }

        @Test
        public void filterCharactersByName() {
            String characterName = "Walder";

            HashMap<String, String> pagination = new HashMap<>();
            pagination.put("name", characterName);

            List<Character> Characters = service.getAllCharacters(pagination);

            assertEquals(1, Characters.size());
            assertEquals(Characters.get(0).getName(), characterName);
        }


        @Test
        public void whenGetCharacterByExistentId_thenCharacterExists() {

            Character expectedCharacter = TestUtils.getSecondCharacter();
            Character actualCharacter = service.getCharacterById(2);

            assertNotNull(actualCharacter);
            assertEquals(actualCharacter.getName(), expectedCharacter.getName());
        }

        @Test
        public void whenGetCharacterByNonExistentId_exceptionThrown() {

            assertThrows(FeignException.class, () -> service.getCharacterById(1233456));
        }
}
