package com.revature.DAOs;

import com.revature.models.Reader;

import java.util.ArrayList;


public interface ReaderDAOInterface {

    ArrayList<Reader> getReaders();

    Reader getReaderById(int id);

    Reader insertReader(Reader read);

    Reader deleteReader(Reader read);

    boolean doesReaderExist(int id);




}
