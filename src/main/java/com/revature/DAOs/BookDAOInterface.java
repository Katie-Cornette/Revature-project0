package com.revature.DAOs;

import com.revature.models.Book;

import java.util.ArrayList;


public interface BookDAOInterface {

    ArrayList<Book> getBooks();

    ArrayList<Book> getBookByReaderId(int id);

    Book insertBookByReaderId(int id);

    Book deleteBookByReaderId(int id);



}
