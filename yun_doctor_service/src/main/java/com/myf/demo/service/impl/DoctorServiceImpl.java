package com.myf.demo.service.impl;

import com.myf.demo.domain.Doctor;
import com.myf.demo.dto.DoctorDTO;
import com.myf.demo.mapper.DoctorMapper;
import com.myf.demo.query.DoctorQuery;
import com.myf.demo.service.DoctorService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class DoctorServiceImpl extends BaseServiceImpl<DoctorQuery,Doctor, DoctorDTO> implements DoctorService {

    @Resource
    private DoctorMapper doctorMapper;


    @Override
    public List<DoctorDTO> getWithoutTeamDoctor() {

        List<Doctor> withoutTeamDoctor = doctorMapper.getWithoutTeamDoctor();
        Iterator<Doctor> iterator = withoutTeamDoctor.iterator();
        List<DoctorDTO> doctorDTOS = new LinkedList<>();

        while (iterator.hasNext()) {
            Doctor next = iterator.next();
            DoctorDTO doctorDTO = new DoctorDTO();
            BeanUtils.copyProperties(next,doctorDTO);
            doctorDTOS.add(doctorDTO);
        }

        return doctorDTOS;

    }
}

