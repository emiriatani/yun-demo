package com.myf.demo.service.impl;

import com.myf.demo.domain.Doctor;
import com.myf.demo.domain.Region;
import com.myf.demo.domain.Team;
import com.myf.demo.dto.TeamDTO;
import com.myf.demo.mapper.TeamMapper;
import com.myf.demo.query.TeamQuery;
import com.myf.demo.service.DoctorService;
import com.myf.demo.service.RegionService;
import com.myf.demo.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeamServiceImpl extends BaseServiceImpl<TeamQuery,Team,TeamDTO>  implements TeamService{

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamServiceImpl.class);

    @Resource
    private TeamMapper teamMapper;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private RegionService regionService;

    @Override
    public int insertSelective(Team record) {

        int i = teamMapper.insertSelective(record);

        LOGGER.info("添加成功的团队信息:" +record);

        Doctor doctor = new Doctor();
        Region region = new Region();
        doctor.setId(record.getTeamLeader());
        doctor.setTeamId(record.getId());
        LOGGER.info("需要修改的医生信息:" + doctor);
        region.setId(record.getRegionId());
        region.setTeamId(record.getId());
        LOGGER.info("需要修改的地区信息:" + region);
        if (i>0){
            i  += doctorService.updateByPrimaryKeySelective(doctor);
            i  += regionService.updateByPrimaryKeySelective(region);
        }

        return i;
    }
}
