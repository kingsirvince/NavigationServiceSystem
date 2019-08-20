package com.company.project.service.impl;

import com.company.project.dao.CheckpointInfoMapper;
import com.company.project.model.CheckpointInfo;
import com.company.project.model.distance.CheckpointInfoDistance;
import com.company.project.service.CheckpointInfoService;
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
public class CheckpointInfoServiceImpl extends AbstractService<CheckpointInfo> implements CheckpointInfoService {
    @Resource
    private CheckpointInfoMapper checkpointInfoMapper;

    @Override
    public List<CheckpointInfoDistance> sortByDistance(BigDecimal longitude, BigDecimal Latitude, Integer num) {
        return checkpointInfoMapper.sortByDistance(longitude, Latitude, num);
    }
}
