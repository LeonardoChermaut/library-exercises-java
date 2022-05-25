package com.api.crud.exercises.repository;

import com.api.crud.exercises.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
