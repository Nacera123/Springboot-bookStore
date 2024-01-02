package com.bookStore.service;

import com.bookStore.entity.MyBookList;
import com.bookStore.repository.MyBooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MyBooksRepository myBooksRepository;

    public  void  saveMyBooks(MyBookList bookList ){
            myBooksRepository.save(bookList);
    }

    public List<MyBookList> getAllMyBooks(){
        return myBooksRepository.findAll();
    }
}
