package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.DockInfoMapper;
import com.company.project.model.DockInfo;
import com.company.project.model.distance.DockInfoDistance;
import com.company.project.service.DockInfoService;
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
public class DockInfoServiceImpl extends AbstractService<DockInfo> implements DockInfoService {
    @Resource
    private DockInfoMapper dockInfoMapper;



    @Override
    public List<DockInfoDistance> sortByDistance(BigDecimal longitude, BigDecimal Latitude,Integer num) {

        return dockInfoMapper.sortByDistance(longitude, Latitude, num);
    }
}
