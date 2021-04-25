package com.myf.demo.service;

import com.myf.demo.common.MyPage;
import com.myf.demo.domain.Team;
import com.myf.demo.dto.TeamDTO;

public interface TeamService{


    int deleteByPrimaryKey(Long id);

    int insert(Team record);

    int insertSelective(Team record);

    Team selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);

    MyPage<TeamDTO>  getAll(String key,int pageIndex,int pageSize,String sortField,String sortOrder);

}
