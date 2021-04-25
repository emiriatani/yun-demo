package com.myf.demo.mapper;

import com.myf.demo.common.MyPage;
import com.myf.demo.dto.UserDTO;
import com.myf.demo.query.UserQuery;
import com.myf.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName com.myf.demo.mapper UserMapperTest
 * @Description
 * @Author Afengis
 * @Date 2021/4/25 14:27
 * @Version V1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;


    @Test
    public void test(){
        UserQuery userQuery = new UserQuery(1, 10, "ID", "ASC", "1");
        MyPage<UserDTO> myPage = userService.selectByConditionPage(userQuery, new UserDTO());
        System.out.println(myPage.toString());

    }
}
