package com.revature;

import com.revature.controllers.BookController;
import com.revature.controllers.ReaderController;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {

    public static void main(String[] args) {

        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("CONNECTION WAS SUCCESSFUL! YIPPEEE!");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("Connect failed!");
        }

        var app = Javalin.create()
                .start(3003)
                .get("/", ctx -> ctx.result("Hello Postman!!"));

        ReaderController rc = new ReaderController();
        BookController bc = new BookController();

        app.get("/readers", rc.getReadersHandler);
        app.get("/books", bc.getBooksHandler);
        app.get("/readers/{id}", rc.getReaderByIdHandler);
        app.get("/books/{id}", bc.getBooksByReaderIdHandler);
        app.post("/books/{id}", bc.insertBookByReaderIdHandler);
        app.post("/readers", rc.insertReaderHandler);
        app.delete("/books/{id}", bc.deleteBookByReaderIdHandler);
        app.delete("/readers/{id}", rc.deleteReaderHandler);


    }
}
