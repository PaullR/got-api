package com.got.gotapi.it;

import com.got.gotapi.TestUtils;
import com.got.gotapi.model.Book;
import com.got.gotapi.service.BookService;
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

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookIT {
    @Autowired
    private BookService service;

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }

    @Test
    public void whenGetAllBooks_thenAllBooksArePresent() {


        List<Book> allBooks = service.getAllBooks(new HashMap<>());

        assertFalse(allBooks.isEmpty());
    }

    @Test
    public void getFirstThreeBooks() {
        HashMap<String, String> pagination = new HashMap<>();
        pagination.put("page", "1");
        pagination.put("pageSize", "3");

        List<Book> books = service.getAllBooks(pagination);

        assertEquals(3, books.size());
    }

    @Test
    public void filterBooksByName() {
        String bookName = "A Game of Thrones";

        HashMap<String, String> pagination = new HashMap<>();
        pagination.put("name", bookName);

        List<Book> books = service.getAllBooks(pagination);

        assertEquals(1, books.size());
        assertEquals(books.get(0).getName(), bookName);
    }


    @Test
    public void whenGetBookByExistentId_thenBookExists() {

        Book expectedBook = TestUtils.getFirstBook();
        Book actualBook = service.getBookById(1);

        assertNotNull(actualBook);
        assertEquals(actualBook.getName(), expectedBook.getName());
        assertEquals(actualBook.getIsbn(), expectedBook.getIsbn());
        assertEquals(actualBook.getAuthors(), expectedBook.getAuthors());
        assertEquals(actualBook.getNumberOfPages(), expectedBook.getNumberOfPages());
    }

    @Test
    public void whenGetBookByNonExistentId_exceptionThrown() {

        assertThrows(FeignException.class, () -> service.getBookById(100));
    }
}
