package com.got.gotapi.feign;

import com.got.gotapi.config.FeignClientConfig;
import com.got.gotapi.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@FeignClient(name = "bookFeignClient",
        url = "${client.book.baseUrl}",
        configuration = FeignClientConfig.class)
public interface GotFeignClient {

    @GetMapping(value = "/books?{queryParams}")
    List<Book> getAllBooks(@SpringQueryMap Map<String, String> queryParams);

    @GetMapping(value = "/books/{id}")
    Book getBookById(@PathVariable int id);

}
