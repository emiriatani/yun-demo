package com.myf.demo.mapper;

import com.myf.demo.domain.Doctor;
import com.myf.demo.query.DoctorQuery;

import java.util.List;

public interface DoctorMapper extends BaseMapper<DoctorQuery, Doctor> {

    List<Doctor> getWithoutTeamDoctor();


}