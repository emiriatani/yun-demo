package com.myf.demo.service.impl;

import com.myf.demo.domain.Team;
import com.myf.demo.dto.TeamDTO;
import com.myf.demo.mapper.TeamMapper;
import com.myf.demo.query.TeamQuery;
import com.myf.demo.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeamServiceImpl extends BaseServiceImpl<TeamQuery,Team,TeamDTO>  implements TeamService{

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamServiceImpl.class);

    @Resource
    private TeamMapper teamMapper;



}
