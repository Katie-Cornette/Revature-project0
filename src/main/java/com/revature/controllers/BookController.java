package com.revature.controllers;

import com.revature.DAOs.BookDAO;
import com.revature.models.Book;
import com.revature.models.Reader;
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

    public Handler getBooksByReaderIdHandler = ctx -> {
        int reader_id = Integer.parseInt(ctx.pathParam("id"));
        try {
            ArrayList<Book> books = bs.getBookByReaderId(reader_id);
            ctx.status(200);
            ctx.json(books);
        } catch(IllegalArgumentException e) {
            ctx.status(400);
            ctx.result(e.getMessage());
        }
    };

    public Handler insertBookByReaderIdHandler = ctx -> {
        int reader_id = Integer.parseInt(ctx.pathParam("id"));
        Book newBook = ctx.bodyAsClass(Book.class);
        try{
            Book insertedBook = bs.insertBookByReaderId(reader_id, newBook);
            ctx.status(201);
            ctx.json(insertedBook);
        }catch(IllegalArgumentException e){
            ctx.status(400);
            ctx.result(e.getMessage());
        }
    };

    public Handler deleteBookByReaderIdHandler = ctx -> {
        int reader_id = Integer.parseInt(ctx.pathParam("id"));
        Book deleteBook = ctx.bodyAsClass(Book.class);
        try{
            bs.deleteBookByReaderId(reader_id, deleteBook);
            ctx.status(201);
            ctx.result("Book Deleted Successfully");
        }catch(IllegalArgumentException e){
            ctx.status(400);
            ctx.result(e.getMessage());
        }
    };
}
