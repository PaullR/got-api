package com.got.gotapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.got.gotapi.model.Book;
import org.assertj.core.util.Lists;

import java.util.List;

public class TestUtils {

    public static Book getFirstBook() {
        Book firstBook = new Book();
        firstBook.setUrl("https://anapioficeandfire.com/api/books/1");
        firstBook.setName("A Game of Thrones");
        firstBook.setIsbn("978-0553103540");
        firstBook.setAuthors(Lists.list("Geogre R. R. Martin"));
        firstBook.setNumberOfPages(694);
        firstBook.setPublisher("Bantam Books");
        firstBook.setCountry("United States");
        firstBook.setMediaType("Hardcover");
        firstBook.setReleased("1996-08-01T00:00:00");
        firstBook.setCharacters(Lists.list("https://anapioficeandfire.com/api/characters/2", "https://anapioficeandfire.com/api/characters/12"));

        return firstBook;
    }

    public static Book getSecondBook() {
        Book secondBook = new Book();
        secondBook.setUrl("https://anapioficeandfire.com/api/books/2");
        secondBook.setName("A Clash of Kings");
        secondBook.setIsbn("978-0553108033");
        secondBook.setAuthors(Lists.list("Geogre R. R. Martin"));
        secondBook.setNumberOfPages(768);
        secondBook.setPublisher("Bantam Books");
        secondBook.setCountry("United States");
        secondBook.setMediaType("Hardcover");
        secondBook.setReleased("1992-02-02T00:00:00");
        secondBook.setCharacters(Lists.list("https://anapioficeandfire.com/api/characters/2", "https" +
                "://anapioficeandfire" +
                ".com/api/characters/12"));

        return secondBook;
    }

    public static List<Book> getBookList() {
        return Lists.list(getFirstBook(), getSecondBook());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
