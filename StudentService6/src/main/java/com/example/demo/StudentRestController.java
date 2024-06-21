package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentRestController {
    @Autowired
    private BookRestConsumer consumer;

    @PostMapping("/create")
    public String insertBook(@RequestParam("bookname") String bookName, @RequestParam("bookcost") Double bookCost) {
        return consumer.insertBook(bookName, bookCost);
    }

    @GetMapping("/allBooks")
    public List<Book> getBooksInfo() {
        return consumer.getAllBooks();
    }

    @GetMapping("/getOneBook/{id}")
    public Book getOneBookForStd(@PathVariable("id") Integer id) {
        return consumer.getBookById(id);
    }

    @GetMapping("/entityData")
    public String printEntityData() {
        ResponseEntity<String> resp = consumer.getEntityData();
        return "Accessing from STUDENT-SERVICE ==> " + resp.getBody() + " , status is:" + resp.getStatusCode();
    }
}
