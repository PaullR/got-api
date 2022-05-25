package com.got.gotapi.service;

import com.got.gotapi.model.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    public List<Book> getAllBooks(Map<String, String> queryParams);

    public Book getBookById(int id);
}
