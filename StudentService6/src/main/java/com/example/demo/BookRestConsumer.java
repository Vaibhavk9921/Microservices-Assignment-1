package com.example.demo;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "BOOK-SERVICE")
public interface BookRestConsumer {

    @PostMapping("/book/create")
    public String insertBook(@RequestParam("bookname") String bookName, @RequestParam("bookcost") Double bookCost);

    @GetMapping("/book/data")
    public String getBookData();

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") Integer id);

    @GetMapping("/book/all")
    public List<Book> getAllBooks();

    @GetMapping("/book/entity")
    public ResponseEntity<String> getEntityData();
}
