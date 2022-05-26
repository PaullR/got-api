package com.got.gotapi.controller;

import com.got.gotapi.TestUtils;
import com.got.gotapi.service.BookService;
import com.got.gotapi.service.CharacterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CharacterService characterService;

    @Test
    public void testGetCharacterBydId() throws Exception {
        when(characterService.getCharacterById(anyInt())).thenReturn(TestUtils.getFirstCharacter());

        mockMvc.perform(get("/characters/1")
                        .content(TestUtils.asJsonString(TestUtils.getFirstCharacter()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetAllCharacters() throws Exception {
        when(characterService.getAllCharacters(anyMap())).thenReturn(TestUtils.getCharacterList());

        mockMvc.perform(get("/characters")
                        .content(TestUtils.asJsonString(TestUtils.getCharacterList()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", hasSize(TestUtils.getBookList().size())));
    }
}
