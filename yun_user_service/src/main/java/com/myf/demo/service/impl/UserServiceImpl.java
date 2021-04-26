package com.myf.demo.service.impl;

import com.myf.demo.common.StatusCode;
import com.myf.demo.domain.User;
import com.myf.demo.dto.UserDTO;
import com.myf.demo.exception.GlobalException;
import com.myf.demo.mapper.UserMapper;
import com.myf.demo.query.UserQuery;
import com.myf.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserQuery, User, UserDTO> implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    /**
     * 查询账号
     *
     * @param record
     * @return
     */
    @Override
    public User selectByUserName(User record) {
        User user = userMapper.selectByUserName(record);
        if (!ObjectUtils.isEmpty(user)) {
            LOGGER.info("user不为空,查询出的用户----> " + user.toString());
            if (user.getStatus().intValue() != 0) {
                LOGGER.info("账号已启用");
                if (user.getAllocationStatus().intValue() != 0) {
                    LOGGER.info("账号已分配");
                    if (user.getPassword().equals(record.getPassword())) {
                        LOGGER.info("账号密码成功匹配");
                        return user;
                    } else {
                        LOGGER.info("密码错误");
                        throw new GlobalException(StatusCode.PWD_ERROR.getCode(), StatusCode.PWD_ERROR.getMsg());
                    }
                } else {
                    LOGGER.info("账号未分配");
                    throw new GlobalException(StatusCode.NO_ALLOCATE_ACCOUNT.getCode(), StatusCode.NO_ALLOCATE_ACCOUNT.getMsg());
                }
            } else {
                LOGGER.info("账号已停用");
                throw new GlobalException(StatusCode.DEACTIVATE_ACCOUNT.getCode(), StatusCode.DEACTIVATE_ACCOUNT.getMsg());
            }
        } else {
            LOGGER.info("user为空");
            throw new GlobalException(StatusCode.NO_ACCOUNT.getCode(), StatusCode.NO_ACCOUNT.getMsg());
        }
    }
}

