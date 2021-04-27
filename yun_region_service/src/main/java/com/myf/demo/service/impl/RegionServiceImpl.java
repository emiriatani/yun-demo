package com.myf.demo.service.impl;

import com.myf.demo.domain.Region;
import com.myf.demo.dto.RegionDTO;
import com.myf.demo.mapper.RegionMapper;
import com.myf.demo.query.RegionQuery;
import com.myf.demo.service.RegionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegionServiceImpl extends BaseServiceImpl<RegionQuery,Region, RegionDTO> implements RegionService{

    @Resource
    private RegionMapper regionMapper;

    @Override
    public List<RegionDTO> getWithoutTeam() {

        List<RegionDTO> withoutTeam = regionMapper.getWithoutTeam();

        return withoutTeam;
    }
}
