package com.myf.demo.query;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @ClassName com.myf.demo.query UserQuery
 * @Description
 * @Author Afengis
 * @Date 2021/4/25 9:38
 * @Version V1.0
 **/

@NoArgsConstructor
@AllArgsConstructor
public class UserQuery extends PageParam {

    private String userNameQueryKey;

    public String getUserNameQueryKey() {
        return userNameQueryKey;
    }

    public void setUserNameQueryKey(String userNameQueryKey) {
        this.userNameQueryKey = userNameQueryKey;
    }

    public UserQuery(int pageIndex, int pageSize, String sortField, String sortOrder, String userNameQueryKey) {
        super(pageIndex, pageSize, sortField, sortOrder);
        this.userNameQueryKey = userNameQueryKey;
    }

    @Override
    public String toString() {
        return "UserQuery{" +
                "userNameQueryKey='" + userNameQueryKey + '\'' +
                "} " + super.toString();
    }
}
