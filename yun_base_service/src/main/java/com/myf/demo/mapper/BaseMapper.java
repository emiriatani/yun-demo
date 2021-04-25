package com.myf.demo.mapper;

import java.util.List;

/**
 * @InterfaceName com.myf.demo.mapper BaseMapper
 * @Description
 * @Author Afengis
 * @Date 2021/4/25 9:20
 * @Version V1.0
 **/
public interface BaseMapper<Q,T> {

    int deleteByPrimaryKey(Long id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    /**
     * dao层通用分页查询方法
     * @param q
     * @return
     */
    List<T> selectByConditionPage(Q q);


}
