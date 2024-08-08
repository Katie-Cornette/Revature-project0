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
                        rs.getDouble("book_price"),
                        rs.getInt("reader_id_fk")
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
    public Book insertBookByReaderId(int id) {
        return null;
    }

    @Override
    public Book deleteBookByReaderId(int id) {
        return null;
    }
}
