package com.company.project.service.impl;

import com.company.project.dao.PipelineInfoMapper;
import com.company.project.model.PipelineInfo;
import com.company.project.model.distance.PipelineInfoDistance;
import com.company.project.service.PipelineInfoService;
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
public class PipelineInfoServiceImpl extends AbstractService<PipelineInfo> implements PipelineInfoService {
    @Resource
    private PipelineInfoMapper pipelineInfoMapper;

    @Override
    public List<PipelineInfoDistance> sortByDistance(BigDecimal longitude, BigDecimal latitude, Integer num) {
        return pipelineInfoMapper.sortByDistance(longitude, latitude, num);
    }

    @Override
    public Integer updateLimitHeight(Double subtrahend) {
        return pipelineInfoMapper.updateLimitHeight(subtrahend);
    }

    @Override
    public Double getByRowField(String field, String row, String rowValue) {
        return pipelineInfoMapper.getByRowField(field, row, rowValue);
    }
}
