package com.myf.demo.query;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName com.myf.demo.query RegionQuery
 * @Description
 * @Author Afengis
 * @Date 2021/4/27 14:55
 * @Version V1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
public class RegionQuery extends PageParam implements Serializable {
    private static final long serialVersionUID = 6111923541793436833L;

    private String regionName;

    public RegionQuery(int pageIndex, int pageSize, String sortField, String sortOrder, String regionName) {
        super(pageIndex, pageSize, sortField, sortOrder);
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "RegionQuery{" +
                "regionName='" + regionName + '\'' +
                "} " + super.toString();
    }
}
