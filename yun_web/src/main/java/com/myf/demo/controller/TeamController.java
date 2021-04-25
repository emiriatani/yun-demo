package com.myf.demo.controller;

import com.myf.demo.common.MyPage;
import com.myf.demo.dto.TeamDTO;
import com.myf.demo.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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
    public MyPage<TeamDTO> getAll(@RequestParam(value = "key", defaultValue = "", required = false) String key,
                                  @RequestParam(value = "pageIndex", defaultValue = "0") String pageIndex,
                                  @RequestParam(value = "pageSize", defaultValue = "10") String pageSize,
                                  @RequestParam(value = "sortField", defaultValue = "id", required = false) String sortField,
                                  @RequestParam(value = "sortOrder", defaultValue = "asc", required = false) String sortOrder,
                                  HttpServletRequest request) throws IOException {

        if (!rpcInterfaceIsValid()) {
            return new MyPage<>();
        }

        LOGGER.info("筛选条件" + key);
        LOGGER.info("页码" + pageIndex);
        LOGGER.info("每页大小" + pageSize);
        LOGGER.info("排序字段" + sortField);
        LOGGER.info("排序方式" + sortOrder);
        int pageIndexInt = Integer.parseInt(pageIndex) + 1;
        int pageSizeInt = Integer.parseInt(pageSize);
        MyPage<TeamDTO> myPage = teamService.getAll(key, pageIndexInt, pageSizeInt, sortField, sortOrder);

        return myPage;
    }


    private boolean rpcInterfaceIsValid() {
        if (ObjectUtils.isEmpty(this.teamService)) {
            LOGGER.info("远程调用失败");
            return false;
        }
        return true;
    }
}
