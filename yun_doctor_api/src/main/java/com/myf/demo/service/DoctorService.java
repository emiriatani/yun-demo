package com.myf.demo.service;

import com.myf.demo.domain.Doctor;
import com.myf.demo.dto.DoctorDTO;
import com.myf.demo.query.DoctorQuery;

import java.util.List;

public interface DoctorService extends BaseService<DoctorQuery, Doctor, DoctorDTO> {


    List<DoctorDTO> getWithoutTeamDoctor();


}

