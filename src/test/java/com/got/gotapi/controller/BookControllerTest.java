package com.got.gotapi.controller;

import com.got.gotapi.TestUtils;
import com.got.gotapi.service.BookService;
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
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void testGetBookBydId() throws Exception {
        when(bookService.getBookById(anyInt())).thenReturn(TestUtils.getFirstBook());

        mockMvc.perform(get("/books/1")
                .content(TestUtils.asJsonString(TestUtils.getFirstBook()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void testGetAllBooks() throws Exception {
        when(bookService.getAllBooks(anyMap())).thenReturn(TestUtils.getBookList());

        mockMvc.perform(get("/books")
                        .content(TestUtils.asJsonString(TestUtils.getBookList()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$", hasSize(TestUtils.getBookList().size())));
    }
}