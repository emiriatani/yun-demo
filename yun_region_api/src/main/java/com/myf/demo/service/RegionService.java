package com.myf.demo.service;

import com.myf.demo.domain.Region;
import com.myf.demo.dto.RegionDTO;
import com.myf.demo.query.RegionQuery;

import java.util.List;

public interface RegionService extends BaseService<RegionQuery, Region,RegionDTO>{


    public List<RegionDTO> getWithoutTeam();



}

