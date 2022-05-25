package com.api.crud.exercises.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BookException extends Exception {

    private Integer id;


    public BookException(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
