package com.myf.demo.controller;

import com.myf.demo.common.MyPage;
import com.myf.demo.dto.TeamDTO;
import com.myf.demo.query.TeamQuery;
import com.myf.demo.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @ClassName com.myf.demo.controller TeamController
 * @Description
 * @Author Afengis
 * @Date 2021/4/23 15:30
 * @Version V1.0
 **/
@RestController
@RequestMapping("/team")
public class TeamController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    private TeamService teamService;


    @RequestMapping("/get")
    public MyPage<TeamDTO> getAll(TeamQuery teamQuery) throws IOException {

        if (!rpcInterfaceIsValid()) {
            return new MyPage<>();
        }

        MyPage<TeamDTO> teamDTOMyPage = teamService.selectByConditionPage(teamQuery, TeamDTO.class);

        for (TeamDTO item :
                teamDTOMyPage.getData()) {
            LOGGER.info("查询出的团队信息:" + item);
        }


        return teamDTOMyPage;
    }


    private boolean rpcInterfaceIsValid() {
        if (ObjectUtils.isEmpty(this.teamService)) {
            LOGGER.info("远程调用失败");
            return false;
        }
        return true;
    }
}
