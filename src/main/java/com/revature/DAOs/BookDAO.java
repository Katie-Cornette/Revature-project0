package com.revature.DAOs;

import com.revature.models.Book;
import com.revature.models.Reader;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class BookDAO implements BookDAOInterface{
    @Override
    public ArrayList<Book> getBooks() {

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM books";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ArrayList<Book> books =new ArrayList<>();

            while(rs.next()){
                Book b = new Book(
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getString("book_author"),
                        rs.getDouble("book_price"),
                        rs.getInt("reader_id_fk")
                );
                ReaderDAO rDAO = new ReaderDAO();
                Reader reader= rDAO.getReaderById(rs.getInt("reader_id_fk"));
                b.setReader(reader);

                books.add(b);
            }

           return books;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Book> getBookByReaderId(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM books WHERE reader_id_fk= ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ArrayList<Book> books = new ArrayList<>();
            while(rs.next()){
                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getString("book_name"),
                        rs.getString("book_author"),
                        rs.getDouble("book_price")
                );
                books.add(book);
            }
            return books;
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Could not get books by reader Id");
        }
        return null;
    }

    @Override
    public Book insertBookByReaderId(int id, Book book) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO books (book_name, book_author, book_price, reader_id_fk) VALUES (?,?,?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, book.getBook_name());
            ps.setString(2, book.getBook_author());
            ps.setDouble(3, book.getBook_price());
            ps.setInt(4, id);
            ps.executeUpdate();

            ReaderDAO rDAO = new ReaderDAO();
            rDAO.updateBookCount(id, 1);

            return book;
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Failed to insert Book!");
        }
        return null;
    }

    @Override
    public Book deleteBookByReaderId(int id, Book book) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "DELETE FROM books WHERE reader_id_fk = ? AND book_name = ? AND book_author = ? AND book_price = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ps.setString(2, book.getBook_name());
            ps.setString(3, book.getBook_author());
            ps.setDouble(4, book.getBook_price());

            ps.executeUpdate();

            ReaderDAO rDAO = new ReaderDAO();
            rDAO.updateBookCount(id, -1);
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Could not delete book");
        }
        return null;
    }
}
