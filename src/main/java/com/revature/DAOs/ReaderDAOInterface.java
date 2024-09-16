package com.revature.DAOs;

import com.revature.models.Reader;

import java.util.ArrayList;


public interface ReaderDAOInterface {

    ArrayList<Reader> getReaders();

    Reader getReaderById(int id);

    Reader insertReader(Reader read);

    Reader deleteReader(int reader_id);

    boolean doesReaderExist(int id);

    void updateBookCount(int reader_id, int value);


}
