package com.revature.DAOs;

import com.revature.models.Book;
import com.revature.models.Reader;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class ReaderDAO implements ReaderDAOInterface{
    @Override
    public ArrayList<Reader> getReaders() {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM readers";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            ArrayList<Reader> readers = new ArrayList<>();

            while(rs.next()){
                Reader r = new Reader(
                        rs.getInt("reader_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("book_count"),
                        null
                );

                BookDAO bDAO = new BookDAO();
                ArrayList<Book> books = bDAO.getBookByReaderId(rs.getInt("reader_id"));
                r.setBooks(books);
                readers.add(r);
            }


            return readers;


        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Reader getReaderById(int id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM readers WHERE reader_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Reader read = new Reader(
                        rs.getInt("reader_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("book_count"),
                        null
                );
                BookDAO bDAO = new BookDAO();
                ArrayList<Book> books = bDAO.getBookByReaderId(rs.getInt("reader_id"));
                read.setBooks(books);
                return read;
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Could not get Reader by Id");
        }
        return null;
    }

    @Override
    public Reader insertReader(Reader read) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO readers (first_name, last_name) VALUES (?,?)";

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Failed to insert new reader");
        }
        return null;
    }

    @Override
    public Reader deleteReader(int reader_id) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "DELETE FROM books WHERE reader_id_fk = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reader_id);
            ps.executeUpdate();

            String sql2 = "DELETE FROM readers WHERE reader_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, reader_id);
            ps2.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Could not delete reader");
        }
        return null;
    }

    @Override
    public boolean doesReaderExist(int id) {
        boolean readerExists = false;
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "Select * FROM readers WHERE reader_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()){
                readerExists = rs.next();
            }

        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Reader does not exist");
        }
        return readerExists;
    }

    @Override
    public void updateBookCount(int reader_id, int value) {
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "UPDATE readers SET book_count = book_count + ? WHERE reader_id =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, value);
            ps.setInt(2, reader_id);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Could not update book count");
        }
    }
}
