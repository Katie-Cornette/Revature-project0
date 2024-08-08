package com.revature.models;

public class Book {

    private int book_id;
    private String book_name;
    private String book_author;
    private double price;
    private int reader_id_fk;

    private Reader reader;

    public Book() {
    }

    public Book(int book_id, String book_name, String book_author, double price) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.price = price;
    }

    public Book(int book_id, String book_name, String book_author, double price, int reader_id_fk) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.price = price;
        this.reader_id_fk = reader_id_fk;
    }

    public Book(int book_id, String book_name, String book_author, double price, int reader_id_fk, Reader reader) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.price = price;
        this.reader_id_fk = reader_id_fk;
        this.reader = reader;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public int getReader_id_fk() {
        return reader_id_fk;
    }

    public void setReader_id_fk(int reader_id_fk) {
        this.reader_id_fk = reader_id_fk;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", book_author='" + book_author + '\'' +
                ", price=" + price +
                ", reader=" + reader +
                ", reader_id_fk=" + reader_id_fk +
                '}';
    }
}
