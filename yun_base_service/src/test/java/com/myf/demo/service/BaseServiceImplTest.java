package com.myf.demo.service;

import com.myf.demo.query.UserQuery;
import com.myf.demo.service.impl.BaseServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName com.myf.demo.service BaseServiceImplTest
 * @Description
 * @Author Afengis
 * @Date 2021/4/25 11:16
 * @Version V1.0
 **/
public class BaseServiceImplTest {

    @Autowired
    private BaseServiceImpl baseService;

    @Test
    public void test() throws IllegalAccessException, InstantiationException {
        UserQuery userQuery = new UserQuery(1, 10, "id", "asc", "admin");
        Class<? extends UserQuery> aClass = userQuery.getClass();
        UserQuery userQuery1 = aClass.newInstance();
        System.out.println(userQuery1.toString());

    }
}
