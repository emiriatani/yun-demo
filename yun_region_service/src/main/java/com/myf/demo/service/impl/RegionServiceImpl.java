package com.myf.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.myf.demo.domain.Region;
import com.myf.demo.mapper.RegionMapper;
import com.myf.demo.service.RegionService;
@Service
public class RegionServiceImpl implements RegionService{

    @Resource
    private RegionMapper regionMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return regionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Region record) {
        return regionMapper.insert(record);
    }

    @Override
    public int insertSelective(Region record) {
        return regionMapper.insertSelective(record);
    }

    @Override
    public Region selectByPrimaryKey(Long id) {
        return regionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Region record) {
        return regionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Region record) {
        return regionMapper.updateByPrimaryKey(record);
    }

}
