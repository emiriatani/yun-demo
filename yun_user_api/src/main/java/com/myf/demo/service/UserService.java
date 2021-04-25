package com.myf.demo.service;

import com.myf.demo.domain.User;
import com.myf.demo.dto.UserDTO;
import com.myf.demo.query.UserQuery;

public interface UserService extends BaseService<UserQuery,User,UserDTO> {

    User selectByUserName(User record);



}

