package com.got.gotapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private String url;
    private String name;
    private String isbn;
    private List<String> authors;
    private int numberOfPages;
    private String publisher;
    private String country;
    private String mediaType;
    private String released;
    private List<String> characters;
    private List<String> povCharacters;
}
