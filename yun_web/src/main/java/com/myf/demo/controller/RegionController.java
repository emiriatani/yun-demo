package com.myf.demo.controller;

import com.myf.demo.dto.RegionDTO;
import com.myf.demo.service.RegionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName com.myf.demo.controller RegionController
 * @Description
 * @Author Afengis
 * @Date 2021/4/27 15:23
 * @Version V1.0
 **/
@RestController
@RequestMapping("/region")
public class RegionController {

    public static final Logger LOGGER = LoggerFactory.getLogger(RegionController.class);

    @Autowired
    private RegionService regionService;

    @RequestMapping("/withoutTeam")
    public List<RegionDTO> getAllWithoutTeam(){
        if (!rpcInterfaceIsValid()) {
            return new ArrayList<>();
        }

        List<RegionDTO> withoutTeam = regionService.getWithoutTeam();

        return withoutTeam;
    }


    private boolean rpcInterfaceIsValid() {
        if (ObjectUtils.isEmpty(this.regionService)) {
            LOGGER.info("远程调用失败");
            return false;
        }
        return true;
    }

}
