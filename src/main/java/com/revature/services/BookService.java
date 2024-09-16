package com.revature.services;

import com.revature.DAOs.BookDAO;
import com.revature.DAOs.ReaderDAO;
import com.revature.models.Book;

import java.util.ArrayList;

public class BookService {

    BookDAO bDAO = new BookDAO();
    ReaderDAO rDAO = new ReaderDAO();

    public ArrayList<Book> getBooks(){
        return bDAO.getBooks();
    }

    public ArrayList<Book> getBookByReaderId(int id){
        if(!rDAO.doesReaderExist(id)){
            throw new IllegalArgumentException("Reader with id " +  id + " does not exist");
        }
        return bDAO.getBookByReaderId(id);
    }

    public Book insertBookByReaderId(int id, Book book){
        if(!rDAO.doesReaderExist(id)){
            throw new IllegalArgumentException("Reader with id " +  id + " does not exist");
        }
        if(book.getBook_name() == null || book.getBook_name().equals("")){
            throw new IllegalArgumentException("Please include book title");
        }
        if(book.getBook_author() == null || book.getBook_author().equals("")){
            throw new IllegalArgumentException("Please include book author");
        }
        if(book.getBook_price() <=0){
            throw new IllegalArgumentException("Price must be positive");
        }
        return bDAO.insertBookByReaderId(id, book);
    }

    public Book deleteBookByReaderId(int id, Book book){
        if(!rDAO.doesReaderExist(id)){
            throw new IllegalArgumentException("Reader with id " +  id + " does not exist");
        }
        if(book.getBook_name() == null || book.getBook_name().equals("")){
            throw new IllegalArgumentException("Please include book title");
        }
        if(book.getBook_author() == null || book.getBook_author().equals("")){
            throw new IllegalArgumentException("Please include book author");
        }
        if(book.getBook_price() == null){
            throw new IllegalArgumentException("Please include a book price");
        }
        if(book.getBook_price() <=0){
            throw new IllegalArgumentException("Price must be positive");
        }
        return bDAO.deleteBookByReaderId(id, book);
    }

}
