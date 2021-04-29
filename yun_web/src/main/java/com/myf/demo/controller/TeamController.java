package com.myf.demo.controller;

import com.myf.demo.common.MyPage;
import com.myf.demo.common.Result;
import com.myf.demo.common.StatusCode;
import com.myf.demo.domain.Team;
import com.myf.demo.domain.User;
import com.myf.demo.dto.TeamDTO;
import com.myf.demo.dto.UserDTO;
import com.myf.demo.query.TeamQuery;
import com.myf.demo.service.TeamService;
import com.myf.demo.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.function.IntFunction;

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

        return teamDTOMyPage;
    }

    @RequestMapping("/add")
    public Result addTeam(@RequestBody TeamDTO teamDTO) {
        if (!rpcInterfaceIsValid()) {
            return ResultUtils.fail(StatusCode.REQ_FAIL.getCode(), StatusCode.REQ_FAIL.getMsg());
        }

        if (ObjectUtils.isEmpty(teamDTO)) {
            return ResultUtils.fail(StatusCode.REQ_FAIL.getCode(), StatusCode.REQ_FAIL.getMsg());
        }

        Team team = new Team();
        BeanUtils.copyProperties(teamDTO, team);
        int i = teamService.insertSelective(team);

        if (i == 3) {
            return ResultUtils.success(StatusCode.REQ_SUCCESS.getCode(), StatusCode.REQ_SUCCESS.getMsg());
        }

        return ResultUtils.fail(StatusCode.REQ_FAIL.getCode(), StatusCode.REQ_FAIL.getMsg());
    }

    @RequestMapping("/query")
    public TeamDTO queryTeam(@RequestParam("id") String id) {
        if (!rpcInterfaceIsValid()) {
            return new TeamDTO();
        }
        Team team = teamService.selectByPrimaryKey(Long.parseLong(id));
        TeamDTO teamDTO = new TeamDTO();
        BeanUtils.copyProperties(team, teamDTO);
        return teamDTO;
    }

    @RequestMapping("/edit")
    public Result edit(@RequestBody TeamDTO teamDTO){

        /*首先判断是否修改了团队长或者管辖区域*/
        Byte updateTeamLeaderState = teamDTO.getUpdateTeamLeaderState();
        Byte updateRegionState = teamDTO.getUpdateRegionState();


        BeanUtils.copyProperties(teamDTO, teamDTO);
        LOGGER.info("需要修改的团队信息:" + teamDTO);
        //int update = teamService.updateByPrimaryKeySelective(teamDTO);

     /*   if (update > 0) {
            return ResultUtils.success(StatusCode.REQ_SUCCESS.getCode(), StatusCode.REQ_SUCCESS.getMsg());
        }*/

        return ResultUtils.fail(StatusCode.REQ_FAIL.getCode(), StatusCode.REQ_FAIL.getMsg());
    }

    private boolean rpcInterfaceIsValid() {
        if (ObjectUtils.isEmpty(this.teamService)) {
            LOGGER.info("远程调用失败");
            return false;
        }
        return true;
    }
}
