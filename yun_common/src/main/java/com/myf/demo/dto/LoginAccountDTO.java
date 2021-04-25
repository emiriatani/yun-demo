package com.myf.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @ClassName com.myf.demo.dto LoginAccountDTO
 * @Description
 * @Author Afengis
 * @Date 2021/4/6 15:45
 * @Version V1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginAccountDTO implements Serializable {

    private static final long serialVersionUID = -2298935912854361574L;

    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;


}
