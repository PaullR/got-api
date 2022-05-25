package com.got.gotapi.service;

import com.got.gotapi.feign.GotFeignClient;
import com.got.gotapi.model.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private final GotFeignClient gotFeignClient;

    @Override
    public List<Book> getAllBooks(Map<String, String> queryParams) {
        log.debug("Get all books");

        return gotFeignClient.getAllBooks(queryParams);
    }

    @Override
    public Book getBookById(int id) {

        log.info("Get book by id: {}", id);
        return gotFeignClient.getBookById(id);
    }
}
