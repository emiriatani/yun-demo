package com.myf.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myf.demo.common.MyPage;
import com.myf.demo.domain.Team;
import com.myf.demo.dto.TeamDTO;
import com.myf.demo.mapper.TeamMapper;
import com.myf.demo.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamServiceImpl.class);

    @Resource
    private TeamMapper teamMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return teamMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Team record) {
        return teamMapper.insert(record);
    }

    @Override
    public int insertSelective(Team record) {
        return teamMapper.insertSelective(record);
    }

    @Override
    public Team selectByPrimaryKey(Long id) {
        return teamMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Team record) {
        return teamMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Team record) {
        return teamMapper.updateByPrimaryKey(record);
    }

    @Override
    public MyPage<TeamDTO> getAll(String key, int pageIndex, int pageSize, String sortField, String sortOrder) {

        /*排序条件筛选*/
        switch (sortField){
            case "id":
                sortField = "ID";
                break;
            case "name":
                sortField = "NAME";
                break;
            case "teamLeaderName":
                sortField = "TEAM_LEADER";
                break;
            case "total":
                sortField = "TOTAL";
                break;
            case "regionName":
                sortField = "REGION_ID";
                break;
            case "stateName":
                sortField = "STATE";
                break;
            case "createTime":
                sortField = "CREATE_TIME";
                break;
            default:
                sortField = "";
        }
        /*分页*/
        PageHelper.startPage(pageIndex, pageSize);
        List<Team> all = teamMapper.getAll(key, sortField, sortOrder);
        PageInfo<Team> teamPageInfo = new PageInfo<>(all);
        List<TeamDTO> teamDTOS = new LinkedList<>();
        Iterator<Team> iterator = teamPageInfo.getList().iterator();
        while (iterator.hasNext()) {
            Team next = iterator.next();
            //查询该团队负责的区域
            next.getRegionId();
            //如果该团队设置了团队长，查询团队长信息
        }


        return null;
    }

}
