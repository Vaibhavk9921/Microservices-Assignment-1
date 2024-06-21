package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookRestController {
	@Autowired
	BookRepository repo;

	@PostMapping("/create")
	public String insertBook(@RequestParam("bookname") String bookName, @RequestParam("bookcost") Double bookCost) {
		Book ob = new Book();
		ob.setBookName(bookName);
		ob.setBookCost(bookCost);
		repo.save(ob);
		return "Book Inserted in Database!!!";
	}

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") Integer id) {
		return repo.findById(id).get();
	}

	@GetMapping("/all")
	public List<Book> getAll() {
		return repo.findAll();
	}

	@GetMapping("/entity")
	public ResponseEntity<String> getEntityData() {
		return new ResponseEntity<String>("Hello from BookRestController", HttpStatus.OK);
	}
}
