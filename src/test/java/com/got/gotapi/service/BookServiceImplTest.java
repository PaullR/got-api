package com.got.gotapi.service;

import com.got.gotapi.TestUtils;
import com.got.gotapi.feign.GotFeignClient;
import com.got.gotapi.model.Book;
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
class BookServiceImplTest {

    @Mock
    private GotFeignClient gotFeignClient;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    public void testGetAllBooks() {
        List<Book> books = TestUtils.getBookList();

        when(gotFeignClient.getAllBooks(anyMap())).thenReturn(books);

        List<Book> actualBookList = bookService.getAllBooks(anyMap());

        assertEquals(books.size(), actualBookList.size());
        assertIterableEquals(books, actualBookList);
    }
    @Test
    public void testGetBookById() {
        Book book = TestUtils.getFirstBook();

        when(gotFeignClient.getBookById(anyInt())).thenReturn(book);

        Book actualBook = bookService.getBookById(anyInt());

        assertEquals(book, actualBook);
    }
}