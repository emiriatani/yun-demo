package com.myf.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.myf.demo.mapper.DoctorMapper;
import com.myf.demo.domain.Doctor;
import com.myf.demo.service.DoctorService;
@Service
public class DoctorServiceImpl implements DoctorService{

    @Resource
    private DoctorMapper doctorMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return doctorMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Doctor record) {
        return doctorMapper.insert(record);
    }

    @Override
    public int insertSelective(Doctor record) {
        return doctorMapper.insertSelective(record);
    }

    @Override
    public Doctor selectByPrimaryKey(Long id) {
        return doctorMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Doctor record) {
        return doctorMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Doctor record) {
        return doctorMapper.updateByPrimaryKey(record);
    }

}
