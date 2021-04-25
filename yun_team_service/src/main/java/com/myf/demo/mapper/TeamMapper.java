package com.myf.demo.mapper;

import com.myf.demo.domain.Team;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);

    List<Team> getAll(@Param("key") String key, @Param("sortField") String sortField, @Param("sortOrder") String sortOrder);


}