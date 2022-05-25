package com.api.crud.exercises.service;

import com.api.crud.exercises.dto.BookDto;
import com.api.crud.exercises.exception.BookException;
import com.api.crud.exercises.model.Book;
import com.api.crud.exercises.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    Book book;
    @Autowired
    BookRepository bookRepository;

//    private List<Book> list = Arrays.asList(new Book
//                    (1, "Corsel", "Sport", 1997),
//            new Book(2, "Mustang", "Sport", 2022),
//            new Book(3, "Viper", "Sport", 1990),
//            new Book(4, "Supra", "Sport", 2001),
//            new Book(5, "Nissan Skyline", "Sport", 2007));

    public void saveBook(BookDto bDTO) {
        Book book = dtoToBook(bDTO);
        bookRepository.save(book);
    }
    public BookDto bookToDTO(Book book){
        BookDto bookDTO = new BookDto();
        bookDTO.setId(book.getId());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setType(book.getType());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setDatePublication(book.getDatePublication());
        return bookDTO;
    }
    public Book dtoToBook(BookDto bookDTO){
        Book book = new Book();
        book.setAuthor(bookDTO.getAuthor());
        book.setType(bookDTO.getType());
        book.setTitle(bookDTO.getTitle());
        book.setDatePublication(bookDTO.getDatePublication());
        return book;
    }

    public void deleteBook(long id){bookRepository.deleteById(id);}

    public List<BookDto> findAll() {
        List<Book> book = bookRepository.findAll();
        List<BookDto> listDTO = new ArrayList<>();
        for (Book books : book ){
            BookDto bookDTO = bookToDTO(books);
            listDTO.add(bookDTO);
        }
        return listDTO;
    }

    public BookDto findOneBook(Long id){
        Optional<Book> book = bookRepository.findById(id);
        Book bookOnData;
        BookDto bookDTO = new BookDto();
        if (book.isPresent()){
            bookOnData = book.get();
            bookToDTO(book.get());
        }
        return bookDTO;
    }

    public void updateBook(Long id, BookDto bookDTO) {
        Optional<Book> book = bookRepository.findById(id);
        Book bookOnBank = new Book();
        if (book.isPresent()) {
            bookOnBank = book.get();
            if (bookDTO.getAuthor() != null) {
                bookOnBank.setAuthor(bookDTO.getAuthor());
            }
            if (bookDTO.getType() != null) {
                bookOnBank.setType(bookDTO.getType());
            }
            if (bookDTO.getTitle() != null) {
                bookOnBank.setTitle(bookDTO.getTitle());
            }
            if (bookDTO.getDatePublication() != null) {
                bookOnBank.setDatePublication(bookDTO.getDatePublication());
            }
            bookRepository.save(bookOnBank);
        }
    }

}
