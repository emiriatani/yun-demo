package com.myf.demo.query;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName com.myf.demo.query TeamQuery
 * @Description
 * @Author Afengis
 * @Date 2021/4/26 10:33
 * @Version V1.0
 **/

@NoArgsConstructor
@AllArgsConstructor
public class TeamQuery extends PageParam implements Serializable {

    private static final long serialVersionUID = -1017148509452555303L;

    private String teamLeaderNameKey;

    public TeamQuery(int pageIndex, int pageSize, String sortField, String sortOrder, String teamLeaderNameKey) {
        super(pageIndex, pageSize, sortField, sortOrder);
        this.teamLeaderNameKey = teamLeaderNameKey;
    }

    public String getTeamLeaderNameKey() {
        return teamLeaderNameKey;
    }

    public void setTeamLeaderNameKey(String teamLeaderNameKey) {
        this.teamLeaderNameKey = teamLeaderNameKey;
    }
}
