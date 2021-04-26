package com.myf.demo.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myf.demo.common.Constants;
import com.myf.demo.common.MyPage;
import com.myf.demo.domain.Doctor;
import com.myf.demo.domain.Team;
import com.myf.demo.domain.User;
import com.myf.demo.dto.DoctorDTO;
import com.myf.demo.dto.TeamDTO;
import com.myf.demo.dto.UserDTO;
import com.myf.demo.mapper.BaseMapper;
import com.myf.demo.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName com.myf.demo.service.impl BaseServiceImpl
 * @Description
 * @Author Afengis
 * @Date 2021/4/25 9:18
 * @Version V1.0
 **/
public class BaseServiceImpl<Q, T, M> implements BaseService<Q, T, M> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Autowired
    private BaseMapper<Q, T> baseMapper;

    @Override
    public int insert(T record) {
        return baseMapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        return baseMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public T selectByPrimaryKey(Long id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        return baseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        return baseMapper.updateByPrimaryKey(record);
    }

    /**
     * 通用分页查询具体实现方法
     *
     * @param obj 查询信息和分页信息的封装对象
     * @return
     */
    @Override
    public MyPage<M> selectByConditionPage(Q obj,Class<M> tem) {

        MyPage<M> tMyPage = new MyPage<>();

        /*获取传入参数的类对象*/
        Class<?> aClass = obj.getClass();
        /*获取全类名*/
        String className = aClass.getName();
        LOGGER.info("传入对象全类名："+ className);

        Method getSortField = null;
        Method getSortOrder = null;
        Method getPageIndex = null;
        Method getPageSize = null;
        Method setSortField = null;

        String sortFieldStr = "";
        String sortOrderStr = "";
        int pageIndex = 1;
        int pageSize = 10;

        try {
            /*getMethod()获取当前类和父类的所有public的方法*/
            /*获取当前运行时类(obj所在的类)的getSortField()方法*/
            getSortField = aClass.getMethod("getSortField");
            getSortOrder = aClass.getMethod("getSortOrder");
            getPageIndex = aClass.getMethod("getPageIndex");
            getPageSize = aClass.getMethod("getPageSize");
            setSortField = aClass.getMethod("setSortField", String.class);

            /*通过反射调用getSortField()*/
            sortFieldStr = (String) getSortField.invoke(obj);
            sortOrderStr = (String) getSortOrder.invoke(obj);
            pageIndex = (int) getPageIndex.invoke(obj);
            pageSize = (int) getPageSize.invoke(obj);

            LOGGER.info("传入的页码：" + pageIndex);
            LOGGER.info("传入的页大小：" + pageSize);
            LOGGER.info("传入的排序字段：" + sortFieldStr);
            LOGGER.info("传入的排序方式：" + sortOrderStr);

            /*根据不同类型执行不同逻辑*/
            sortFieldStr = selectQuerySortField(sortFieldStr,tem);
            setSortField.invoke(obj, sortFieldStr);

            /*分页查询数据*/
            PageHelper.startPage(pageIndex, pageSize);
            List<T> ts = baseMapper.selectByConditionPage(obj);
            PageInfo<T> tPageInfo = new PageInfo<>(ts);
            List<M> oneDTOS = new LinkedList<>();
            Iterator<T> iterator = tPageInfo.getList().iterator();
            /*封装查询出来的数据*/
            while (iterator.hasNext()) {
                T next = iterator.next();
                M mdone = beanToBeanDTO(next,tem);
                oneDTOS.add(mdone);
            }
            tMyPage.setTotal(tPageInfo.getTotal());
            tMyPage.setData(oneDTOS);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return tMyPage;
    }

    private String selectQuerySortField(String sortField,Class<M> clazz) {
        String className = clazz.getName();
        if (Constants.USERDTO.equals(className)){
            switch (sortField) {
                case "id":
                    sortField = "ID";
                    break;
                case "username":
                    sortField = "USERNAME";
                    break;
                case "loginName":
                    sortField = "LOGIN_NAME";
                    break;
                case "account":
                    sortField = "STATUS";
                    break;
                case "allocation":
                    sortField = "ALLOCATION_STATUS";
                    break;
                case "createTime":
                    sortField = "CREATE_TIME";
                    break;
                default:
                    sortField = "";
            }
        }else if (Constants.TEAMDTO.equals(className)){
            switch (sortField) {
                case "id":
                    sortField = "ID";
                    break;
                case "name":
                    sortField = "NAME";
                    break;
                case "teamLeaderName":
                    sortField = "TEAM_LEADER";
                    break;
                case "total":
                    sortField = "TOTAL";
                    break;
                case "regionName":
                    sortField = "REGION_ID";
                    break;
                case "stateName":
                    sortField = "STATE";
                    break;
                case "createTime":
                    sortField = "CREATE_TIME";
                    break;
                default:
                    sortField = "";
            }
        }else if (Constants.DOCTORDTO.equals(className)){
            switch (sortField) {
                case "id":
                    sortField = "ID";
                    break;
                case "name":
                    sortField = "NAME";
                    break;
                case "teamName":
                    sortField = "teamName";
                    break;
                case "userName":
                    sortField = "userName";
                    break;
                case "stateName":
                    sortField = "STATE";
                    break;
                case "createTime":
                    sortField = "CREATE_TIME";
                    break;
                default:
                    sortField = "";
            }
        }
        return sortField;
    }

    private M beanToBeanDTO(T obj,Class<M> tem) {
        M instance = null;
        try {
            instance = tem.newInstance();
            if (obj instanceof User && instance instanceof UserDTO) {
                BeanUtils.copyProperties(obj, instance);
                ((UserDTO) instance).setAccountStatus();
                ((UserDTO) instance).setAllocationStatusTip();
            }else if (obj instanceof Team && instance instanceof TeamDTO){
                BeanUtils.copyProperties(obj, instance);
                ((TeamDTO) instance).setStateName();
                ((TeamDTO) instance).checkTeamLeader();
            }else if (obj instanceof Doctor && instance instanceof DoctorDTO){
                BeanUtils.copyProperties(obj, instance);
                ((DoctorDTO) instance).setStateName();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return instance;
    }


}
