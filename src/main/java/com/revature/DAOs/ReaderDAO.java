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
        return null;
    }

    @Override
    public Reader deleteReader(Reader read) {
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
}
