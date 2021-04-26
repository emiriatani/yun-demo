package com.myf.demo.service;

import com.myf.demo.common.MyPage;

/**
 * @ClassName com.myf.demo.service BaseService
 * @Description
 * @Author Afengis
 * @Date 2021/4/25 8:48
 * @Version V1.0
 **/
public interface BaseService<Q, T, M> {

    int insert(T record);

    int insertSelective(T record);

    int deleteByPrimaryKey(Long id);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    /**
     * 通用分页查询接口
     *
     * @param obj 查询信息和分页信息的封装对象
     * @return
     */
    MyPage<M> selectByConditionPage(Q obj, Class<M> tem);

}
