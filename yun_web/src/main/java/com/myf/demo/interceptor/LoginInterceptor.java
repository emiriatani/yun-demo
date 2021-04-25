package com.myf.demo.interceptor;

import com.myf.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName com.myf.demo.interceptor LoginInterceptor
 * @Description
 * @Author Afengis
 * @Date 2021/4/20 11:01
 * @Version V1.0
 **/
public class LoginInterceptor implements HandlerInterceptor{

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        /*在controller方法之前执行*/
//        User user = (User) request.getSession().getAttribute(Constants.CURRENT_USER_KEY);
//        if (ObjectUtils.isEmpty(user)) {
//            logger.info("未登录状态的操作,请先登录");
//            throw new GlobalException(StatusCode.NO_LOGIN_OPERATION.getCode(), StatusCode.NO_LOGIN_OPERATION.getMsg());
//        } else {
//            logger.info("拦截即将通过...");
//            return true;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /*在controller方法之后执行*/
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /*在视图渲染成功之后执行*/
    }
}
