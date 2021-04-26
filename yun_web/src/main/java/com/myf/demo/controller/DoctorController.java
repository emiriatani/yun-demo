package com.myf.demo.controller;

import com.myf.demo.common.MyPage;
import com.myf.demo.dto.DoctorDTO;
import com.myf.demo.query.DoctorQuery;
import com.myf.demo.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName com.myf.demo.controller DoctorController
 * @Description
 * @Author Afengis
 * @Date 2021/4/26 14:58
 * @Version V1.0
 **/
@RestController
@RequestMapping("/doctor")
public class DoctorController {

    public static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    private DoctorService doctorService;


    @RequestMapping("/get")
    public MyPage<DoctorDTO> getAll(DoctorQuery doctorQuery){

        if (!rpcInterfaceIsValid()) {
            return new MyPage<>();
        }

        MyPage<DoctorDTO> doctorDTOMyPage = doctorService.selectByConditionPage(doctorQuery, DoctorDTO.class);
        return doctorDTOMyPage;
    }

    @RequestMapping("/withoutTeam")
    public List<DoctorDTO> getAllWithoutTeamDoctor(){
        if (!rpcInterfaceIsValid()) {
            return new ArrayList<>();
        }

        List<DoctorDTO> withoutTeamDoctor = doctorService.getWithoutTeamDoctor();

        return withoutTeamDoctor;
    }


    private boolean rpcInterfaceIsValid() {
        if (ObjectUtils.isEmpty(this.doctorService)) {
            LOGGER.info("远程调用失败");
            return false;
        }
        return true;
    }

}
