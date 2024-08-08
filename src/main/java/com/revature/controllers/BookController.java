package com.revature.controllers;

import com.revature.DAOs.BookDAO;
import com.revature.models.Book;
import com.revature.services.BookService;
import io.javalin.http.Handler;

import java.util.ArrayList;


public class BookController {

    BookService bs = new BookService();

    public Handler getBooksHandler = ctx -> {
        ArrayList<Book> books = bs.getBooks();
        ctx.json(books);
        ctx.status(200);
    };
}
