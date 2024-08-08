package com.revature.models;

import java.util.ArrayList;

public class Reader {

    private int reader_id;
    private String first_name;
    private String last_name;
    private int book_count;
    private ArrayList<Book> books;

    public Reader() {
    }

    public Reader(int reader_id, String first_name, String last_name, int book_count, ArrayList<Book> books) {
        this.reader_id = reader_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.book_count = book_count;
        this.books = books;
    }

    public Reader(int reader_id, String first_name, String last_name) {
        this.reader_id = reader_id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Reader(int reader_id, String first_name, String last_name, int book_count) {
        this.reader_id = reader_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.book_count = book_count;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getBook_count() {
        return book_count;
    }

    public void setBook_count(int book_count) {
        this.book_count = book_count;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "reader_id=" + reader_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", book_count=" + book_count +
                ", books=" + books +
                '}';
    }
}
