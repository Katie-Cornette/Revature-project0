package com.revature.controllers;

import com.revature.models.Reader;
import com.revature.services.ReaderService;

import java.util.ArrayList;
import io.javalin.http.Handler;

public class ReaderController {

    ReaderService rs = new ReaderService();

    public Handler getReadersHandler = ctx -> {
        ArrayList<Reader> readers = rs.getReaders();
        ctx.json(readers);
        ctx.status(200);
    };

    public Handler getReaderByIdHandler = ctx -> {
        int reader_id = Integer.parseInt(ctx.pathParam("id"));
        try {
            Reader reader = rs.getReaderById(reader_id);
            ctx.status(200);
            ctx.json(reader);
        } catch(IllegalArgumentException e){
            ctx.status(400);
            ctx.result(e.getMessage());


        }
    };

    public Handler insertReaderHandler = ctx -> {
        Reader newReader = ctx.bodyAsClass(Reader.class);
        try{
            rs.insertReader(newReader);
            ctx.status(200);
            ctx.json(newReader);
        }catch(IllegalArgumentException e){
            ctx.status(400);
            ctx.result(e.getMessage());
        }

    };

    public Handler deleteReaderHandler = ctx -> {
        int reader_id = Integer.parseInt(ctx.pathParam("id"));
        try{
            rs.deleteReader(reader_id);
            ctx.status(200);
            ctx.json("Reader was deleted successfully");
        }catch(IllegalArgumentException e){
            ctx.status(400);
            ctx.result(e.getMessage());
        }
    };

}

