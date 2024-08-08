package com.revature.services;

import com.revature.DAOs.BookDAO;
import com.revature.models.Book;

import java.util.ArrayList;

public class BookService {

    BookDAO bDAO = new BookDAO();

    public ArrayList<Book> getBooks(){
        return bDAO.getBooks();
    }


}
