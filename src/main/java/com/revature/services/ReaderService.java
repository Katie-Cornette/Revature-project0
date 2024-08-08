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

}
