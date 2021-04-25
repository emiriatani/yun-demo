package com.myf.demo.controller;

import com.myf.demo.common.Constants;
import com.myf.demo.common.MyPage;
import com.myf.demo.common.Result;
import com.myf.demo.common.StatusCode;
import com.myf.demo.domain.User;
import com.myf.demo.dto.LoginAccountDTO;
import com.myf.demo.dto.UserDTO;
import com.myf.demo.query.UserQuery;
import com.myf.demo.service.UserService;
import com.myf.demo.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName com.myf.demo.controller UserController
 * @Description
 * @Author Afengis
 * @Date 2021/4/6 13:31
 * @Version V1.0
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result<Object> login(@RequestBody LoginAccountDTO loginAccountDTO,
                                HttpServletRequest request) {
        if (!rpcInterfaceIsValid()) {
            return ResultUtils.fail(StatusCode.REQ_FAIL.getCode(), StatusCode.REQ_FAIL.getMsg());
        }

        LOGGER.info("页面传过来的对象----> " + loginAccountDTO.toString());
        User tem_user = new User();
        BeanUtils.copyProperties(loginAccountDTO, tem_user);
        LOGGER.info("需要查询的用户----> " + tem_user.toString());
        System.out.println(userService);
        User user = userService.selectByUserName(tem_user);
        if (!ObjectUtils.isEmpty(user)) {
            LOGGER.info("查询出的用户----> " + user.toString());
            request.getSession().setAttribute(Constants.CURRENT_USER_KEY, user);
            return ResultUtils.success(StatusCode.REQ_SUCCESS.getCode(), StatusCode.REQ_SUCCESS.getMsg(), user.getId());
        } else {
            return ResultUtils.fail(StatusCode.LOGIN_FAIL.getCode(), StatusCode.LOGIN_FAIL.getMsg());
        }
    }

    @RequestMapping("/get")
    public MyPage<UserDTO> getPage(UserQuery userQuery) {

        if (!rpcInterfaceIsValid()) {
            return new MyPage<>();
        }

        MyPage<UserDTO> myPage = userService.selectByConditionPage(userQuery, new UserDTO());

        return myPage;
    }

    @RequestMapping("/add")
    public Result<Object> add(@RequestBody UserDTO userDTO) {

        if (!rpcInterfaceIsValid()) {
            return ResultUtils.fail(StatusCode.REQ_FAIL.getCode(), StatusCode.REQ_FAIL.getMsg());
        }

        LOGGER.info("需要添加的账号:" + userDTO);
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        int i = userService.insertSelective(user);
        if (i > 0) {
            LOGGER.info("添加账号成功");
            return ResultUtils.success(StatusCode.REQ_SUCCESS.getCode(), StatusCode.REQ_SUCCESS.getMsg());
        } else {
            LOGGER.info("添加账号失败");
            return ResultUtils.fail(StatusCode.REQ_FAIL.getCode(), StatusCode.REQ_FAIL.getMsg());
        }

    }

    @RequestMapping("/edit")
    public Result<Object> edit(@RequestBody UserDTO userDTO) {

        if (!rpcInterfaceIsValid()) {
            return ResultUtils.fail(StatusCode.REQ_FAIL.getCode(), StatusCode.REQ_FAIL.getMsg());
        }

        LOGGER.info("需要修改的账号:" + userDTO);
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        int update = userService.updateByPrimaryKeySelective(user);
        LOGGER.info(String.valueOf(update));
        if (update > 0) {
            LOGGER.info("修改账号成功");
            return ResultUtils.success(StatusCode.REQ_SUCCESS.getCode(), StatusCode.REQ_SUCCESS.getMsg());
        } else {
            LOGGER.info("修改账号失败");
            return ResultUtils.fail(StatusCode.REQ_FAIL.getCode(), StatusCode.REQ_FAIL.getMsg());
        }
    }

    @RequestMapping("/query")
    public UserDTO query(@RequestParam("id")String id) {

        if (!rpcInterfaceIsValid()) {
            return new UserDTO();
        }
        User user = userService.selectByPrimaryKey(Long.parseLong(id));
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }

    @RequestMapping("/delete")
    public Result<Object> delete(@RequestParam("id")String id) {

        if (!rpcInterfaceIsValid()) {
            return ResultUtils.fail(StatusCode.REQ_FAIL.getCode(), StatusCode.REQ_FAIL.getMsg());
        }
        int i = userService.deleteByPrimaryKey(Long.parseLong(id));
        if (i>0){
            return  ResultUtils.success(StatusCode.REQ_SUCCESS.getCode(), StatusCode.REQ_SUCCESS.getMsg());
        }else {
            return ResultUtils.fail(StatusCode.REQ_FAIL.getCode(),StatusCode.REQ_FAIL.getMsg());
        }
    }

    private boolean rpcInterfaceIsValid() {
        if (ObjectUtils.isEmpty(this.userService)) {
            LOGGER.info("远程调用失败");
            return false;
        }
        return true;
    }
}
