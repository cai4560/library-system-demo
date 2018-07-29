package com.thoughtworks.library.mapper;

import com.thoughtworks.library.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> listAll();

    User findById(Integer id);
}
