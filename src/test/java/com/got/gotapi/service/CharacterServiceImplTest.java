package com.got.gotapi.service;

import com.got.gotapi.TestUtils;
import com.got.gotapi.feign.GotFeignClient;
import com.got.gotapi.model.Character;
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
public class CharacterServiceImplTest {
    @Mock
    private GotFeignClient gotFeignClient;

    @InjectMocks
    private CharacterServiceImpl characterService;

    @Test
    public void testGetAllCharacters() {
        List<Character> characters = TestUtils.getCharacterList();

        when(gotFeignClient.getAllCharacters(anyMap())).thenReturn(characters);

        List<Character> actualCharacterList = characterService.getAllCharacters(anyMap());

        assertEquals(characters.size(), actualCharacterList.size());
        assertIterableEquals(characters, actualCharacterList);
    }
    @Test
    public void testGetCharacterById() {
        Character character = TestUtils.getFirstCharacter();

        when(gotFeignClient.getCharacterById(anyInt())).thenReturn(character);

        Character actualCharacter = characterService.getCharacterById(anyInt());

        assertEquals(character, actualCharacter);
    }
}