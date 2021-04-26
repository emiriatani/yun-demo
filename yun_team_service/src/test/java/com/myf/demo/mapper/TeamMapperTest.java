package com.myf.demo.mapper;

import com.myf.demo.domain.Team;
import com.myf.demo.query.TeamQuery;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @ClassName com.myf.demo.mapper TeamMapperTest
 * @Description
 * @Author Afengis
 * @Date 2021/4/26 13:26
 * @Version V1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application.xml")
public class TeamMapperTest {

    @Autowired
    private TeamMapper teamMapper;

    @Test
    public void test(){
        TeamQuery teamQuery = new TeamQuery(1, 10, "", "", "");
        List<Team> teams = teamMapper.selectByConditionPage(teamQuery);
        for (Team item :
                teams) {
            System.out.println(item.toString());
        }
    }
}
