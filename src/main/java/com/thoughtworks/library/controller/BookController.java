package com.thoughtworks.library.controller;

import com.thoughtworks.library.model.Book;
import com.thoughtworks.library.model.User;
import com.thoughtworks.library.service.BookService;
import com.thoughtworks.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.thoughtworks.library.constant.Constant.ERROR_MESSAGE.NO_PERMISSION;
import static com.thoughtworks.library.constant.Constant.ERROR_MESSAGE.UPLOAD_BOOKS_FAIL;
import static com.thoughtworks.library.constant.Constant.SUCCESS_MESSAGE.UPLOAD_BOOKS_SUCCESS;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/{id}")
    public Book findBookById(@PathVariable("id") Integer bookId) {
        return bookService.findBookById(bookId);
    }

    @RequestMapping("")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ResponseEntity<String> uploadUsers(@RequestHeader(value = "token") String token,
                                              @RequestBody List<Book> books) {
        User currentUser = userService.findUserByToken(token);
        if (null == currentUser || !currentUser.isAdmin()) {
            return new ResponseEntity<>(NO_PERMISSION, HttpStatus.UNAUTHORIZED);
        }

        try {
            bookService.uploadBooks(books);
            return new ResponseEntity<>(UPLOAD_BOOKS_SUCCESS, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(UPLOAD_BOOKS_FAIL, HttpStatus.OK);
        }
    }
}
