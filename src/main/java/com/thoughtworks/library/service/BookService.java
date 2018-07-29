package com.thoughtworks.library.service;

import com.thoughtworks.library.mapper.BookMapper;
import com.thoughtworks.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public Book findBookById(Integer id) {
        return bookMapper.findById(id);
    }

    public List<Book> getAllBooks() {
        return bookMapper.listAll();
    }

    public void uploadBooks(List<Book> books) {
        bookMapper.createBooks(books);
    }

    public void updateStatus(Integer bookId, Integer status) {
        bookMapper.updateStatus(bookId, status);
    }
}
