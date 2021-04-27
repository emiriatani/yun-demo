package com.myf.demo.mapper;

import com.myf.demo.domain.Region;
import com.myf.demo.dto.RegionDTO;
import com.myf.demo.query.RegionQuery;

import java.util.List;

public interface RegionMapper extends BaseMapper<RegionQuery, Region> {

    List<RegionDTO> getWithoutTeam();

}