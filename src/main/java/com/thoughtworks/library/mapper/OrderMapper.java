package com.thoughtworks.library.mapper;

import com.thoughtworks.library.model.Order;
import com.thoughtworks.library.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> listAll(User user);

    Order findById(Integer id);

    void create(@Param("bookId") Integer bookId,
                @Param("userId") Integer userId);

    void delete(Integer id);
}
