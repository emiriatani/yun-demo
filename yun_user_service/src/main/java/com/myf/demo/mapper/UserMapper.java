package com.myf.demo.mapper;

import com.myf.demo.domain.User;
import com.myf.demo.query.UserQuery;

public interface UserMapper extends BaseMapper<UserQuery,User> {

    User selectByUserName(User user);

}