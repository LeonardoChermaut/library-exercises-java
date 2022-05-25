package com.api.crud.exercises.controller;

import com.api.crud.exercises.dto.BookDto;
import com.api.crud.exercises.exception.BookException;
import com.api.crud.exercises.model.Book;
import com.api.crud.exercises.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping()
    public ResponseEntity<List<BookDto>> findAllBooks(){
        bookService.findAll();
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> findBookById(@PathVariable Long id) {
      bookService.findOneBook(id);
      return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity<Void> saveBook(@RequestBody BookDto bookDTO) {
        bookService.saveBook(bookDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PutMapping("/id}")
    public ResponseEntity<Void> updateBook(@PathVariable long id, @RequestBody BookDto book) {
        bookService.updateBook(id, book);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
