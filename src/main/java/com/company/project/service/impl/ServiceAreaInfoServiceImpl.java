package com.company.project.service.impl;

import com.company.project.dao.ServiceAreaInfoMapper;
import com.company.project.model.ServiceAreaInfo;
import com.company.project.model.distance.ServiceAreaInfoDistance;
import com.company.project.service.ServiceAreaInfoService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
@Service
@Transactional
public class ServiceAreaInfoServiceImpl extends AbstractService<ServiceAreaInfo> implements ServiceAreaInfoService {
    @Resource
    private ServiceAreaInfoMapper serviceAreaInfoMapper;

    @Override
    public Integer updateServiceAreaInfoBetweenId(Integer id1, Integer id2) {
        return serviceAreaInfoMapper.updateServiceAreaInfoBetweenId(id1,id2);
    }

    @Override
    public List<ServiceAreaInfo> singleQuery(String fieldName, String value, String fieldName1) {
        return serviceAreaInfoMapper.singleQuery(fieldName,value,fieldName1);
    }

    @Override
    public List<ServiceAreaInfoDistance> sortByDistance(BigDecimal longitude, BigDecimal latitude, Integer num) {
        return serviceAreaInfoMapper.sortByDistance(longitude, latitude, num);
    }
}
