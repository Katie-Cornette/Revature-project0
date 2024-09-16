package com.revature.services;

import com.revature.DAOs.ReaderDAO;
import com.revature.models.Reader;

import java.util.ArrayList;

public class ReaderService {

    ReaderDAO rDAO = new ReaderDAO();

    public ArrayList<Reader> getReaders(){
        return rDAO.getReaders();
    }

    public Reader getReaderById(int id) {
        if(!rDAO.doesReaderExist(id)){
            throw new IllegalArgumentException("Reader with id " +  id + " does not exist");
        }
        return rDAO.getReaderById(id);
    }

    public Reader insertReader(Reader reader){
        if(reader.getFirst_name() == null || reader.getFirst_name().equals("")){
            throw new IllegalArgumentException("Please Enter First Name");
        }
        if(reader.getLast_name() == null || reader.getLast_name().equals("")){
            throw new IllegalArgumentException("Please Enter Last Name");
        }
        return rDAO.insertReader(reader);
    }

    public Reader deleteReader(int reader_id){
        if(!rDAO.doesReaderExist(reader_id)){
            throw new IllegalArgumentException("Reader with id " +  reader_id + " does not exist");
        }
        return rDAO.deleteReader(reader_id);
    }

}
