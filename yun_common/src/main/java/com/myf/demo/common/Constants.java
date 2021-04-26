package com.myf.demo.common;

/**
 * @ClassName com.myf.demo.common Constants
 * @Description
 * @Author Afengis
 * @Date 2021/4/12 9:03
 * @Version V1.0
 **/
public class Constants {


    public static final String CURRENT_USER_KEY = "current_user";

    /*请求响应码*/
    public static final Integer SERVER_ERROR = 500;
    public static final Integer SUCCESS = 200;
    public static final Integer FAIL = 400;

    /*用户模块*/
    public static final Integer NO_REGISTER = 4001;


    public static final String USERDTO = "com.myf.demo.dto.UserDTO";
    public static final String TEAMDTO = "com.myf.demo.dto.TeamDTO";
    public static final String DOCTORDTO = "com.myf.demo.dto.DoctorDTO";

    public static final String USERQUERY =  "com.myf.demo.query.UserQuery";
    public static final String USER = "com.myf.demo.domain.User";


}
