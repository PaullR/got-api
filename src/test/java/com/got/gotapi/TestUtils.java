package com.got.gotapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.got.gotapi.model.Book;
import com.got.gotapi.model.Character;
import com.got.gotapi.model.House;
import org.assertj.core.util.Lists;

import java.util.List;

public class TestUtils {

    public static Book getFirstBook() {
        Book firstBook = new Book();
        firstBook.setUrl("https://anapioficeandfire.com/api/books/1");
        firstBook.setName("A Game of Thrones");
        firstBook.setIsbn("978-0553103540");
        firstBook.setAuthors(Lists.list("George R. R. Martin"));
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
        secondBook.setAuthors(Lists.list("George R. R. Martin"));
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

    public static Character getFirstCharacter() {
        Character firstCharacter = new Character();
        firstCharacter.setUrl("https://www.anapioficeandfire.com/api/characters/1");
        firstCharacter.setName("Tyrion Lannister");

        return firstCharacter;
    }

    public static Character getSecondCharacter() {
        Character secondCharacter = new Character();
        secondCharacter.setUrl("https://www.anapioficeandfire.com/api/characters/2");
        secondCharacter.setName("Walder");

        return secondCharacter;
    }

    public static List<Character> getCharacterList() {
        return Lists.list(getFirstCharacter(), getSecondCharacter());
    }

    public static House getFirstHouse() {
        House firstHouse = new House();
        firstHouse.setUrl("https://www.anapioficeandfire.com/api/houses/1");
        firstHouse.setName("House Algood");
        firstHouse.setRegion("The Westerlands");

        return firstHouse;
    }

    public static House getSecondHouse() {
        House secondHouse = new House();
        secondHouse.setUrl("https://www.anapioficeandfire.com/api/characters/2");
        secondHouse.setName("House Allyrion of Godsgrace");
        secondHouse.setRegion("Dorne");

        return secondHouse;
    }

    public static List<House> getHouseList() {
        return Lists.list(getFirstHouse(), getSecondHouse());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
