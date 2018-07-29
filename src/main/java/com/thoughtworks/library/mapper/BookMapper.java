package com.thoughtworks.library.mapper;

import com.thoughtworks.library.model.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> listAll();

    Book findById(Integer id);

    void createBooks(List<Book> books);

    void updateStatus(@Param("bookId") Integer bookId,
                      @Param("status") Integer status);
}
