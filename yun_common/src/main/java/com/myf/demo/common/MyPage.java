package com.myf.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName com.myf.demo.common MyPage
 * @Description
 * @Author Afengis
 * @Date 2021/4/22 10:19
 * @Version V1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPage<Object> implements Serializable {

    @NotNull
    private Long total;
    @NotNull
    private List<Object> data;


}
