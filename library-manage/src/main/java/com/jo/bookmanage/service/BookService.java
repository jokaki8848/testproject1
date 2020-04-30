package com.jo.bookmanage.service;

import com.jo.bookmanage.bean.Book;
import com.jo.bookmanage.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookMapper bookMapper;

    public List<Book> getById(int id) {
        return bookMapper.getById(id);
    }

    public List<Book> getAll() {
        return bookMapper.getAll();
    }

    public int addbook(Book book) {
        return bookMapper.addbook(book);

    }

    public void delete(int id) {
        bookMapper.deletebook(id);

    }

    public void update(Book book) {
        bookMapper.updatebook(book);
    }
}
