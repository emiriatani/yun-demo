package com.myf.demo.query;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName com.myf.demo.query DoctorQuery
 * @Description
 * @Author Afengis
 * @Date 2021/4/26 15:03
 * @Version V1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
public class DoctorQuery extends PageParam implements Serializable {

    private static final long serialVersionUID = 5474239658897897326L;

    private String doctorName;

    public DoctorQuery(int pageIndex, int pageSize, String sortField, String sortOrder, String doctorName) {
        super(pageIndex, pageSize, sortField, sortOrder);
        this.doctorName = doctorName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Override
    public String toString() {
        return "DoctorQuery{" +
                "doctorName='" + doctorName + '\'' +
                "} " + super.toString();
    }
}
