package com.thoughtworks.library.controller;

import com.thoughtworks.library.model.Book;
import com.thoughtworks.library.model.CreateOrderRequest;
import com.thoughtworks.library.model.Order;
import com.thoughtworks.library.model.User;
import com.thoughtworks.library.service.BookService;
import com.thoughtworks.library.service.OrderService;
import com.thoughtworks.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.thoughtworks.library.constant.Constant.ERROR_MESSAGE.*;
import static com.thoughtworks.library.constant.Constant.SUCCESS_MESSAGE.CREATE_ORDER_SUCCESS;
import static com.thoughtworks.library.constant.Constant.SUCCESS_MESSAGE.DELETE_ORDER_SUCCESS;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "")
    public ResponseEntity<Object> getAllOrders(@RequestHeader(value = "token") String token) {
        User currentUser = userService.findUserByToken(token);
        if (null == currentUser) {
            return new ResponseEntity<>(NO_PERMISSION, HttpStatus.UNAUTHORIZED);
        }

        List<Order> orderList = orderService.getAllOrders(currentUser);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<String> createOrder(@RequestHeader(value = "token") String token,
                                              @RequestBody CreateOrderRequest request) {
        User currentUser = userService.findUserByToken(token);
        if (null == currentUser) {
            return new ResponseEntity<>(NO_PERMISSION, HttpStatus.UNAUTHORIZED);
        }

        Book book = bookService.findBookById(request.getBookId());
        if (null == book) {
            return new ResponseEntity<>(BOOK_NOT_FOUND, HttpStatus.OK);
        }
        if (!book.getIsAvailable()) {
            return new ResponseEntity<>(BOOK_NOT_AVAILABLE, HttpStatus.OK);
        }

        try {
            orderService.createOrder(request.getBookId(), currentUser.getId());
            bookService.updateStatus(request.getBookId(), Book.INVALID_STATUS);
            return new ResponseEntity<>(CREATE_ORDER_SUCCESS, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(CREATE_ORDER_FAIL, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOrder(@RequestHeader(value = "token") String token,
                                              @PathVariable("id") Integer orderId) {
        User currentUser = userService.findUserByToken(token);
        if (null == currentUser || !currentUser.isAdmin()) {
            return new ResponseEntity<>(NO_PERMISSION, HttpStatus.UNAUTHORIZED);
        }

        Order order = orderService.findOrderById(orderId);
        if (null == order) {
            return new ResponseEntity<>(ORDER_NOT_FOUND, HttpStatus.OK);
        }

        try {
            orderService.deleteOrder(orderId);
            bookService.updateStatus(order.getBook().getId(), Book.VALID_STATUS);
            return new ResponseEntity<>(DELETE_ORDER_SUCCESS, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(DELETE_ORDER_FAIL, HttpStatus.OK);
        }
    }
}
