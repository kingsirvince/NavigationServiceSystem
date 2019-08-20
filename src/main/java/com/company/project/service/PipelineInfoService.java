package com.company.project.service;
import com.company.project.model.PipelineInfo;
import com.company.project.core.Service;
import com.company.project.model.distance.PipelineInfoDistance;

import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
public interface PipelineInfoService extends Service<PipelineInfo> {
    List<PipelineInfoDistance> sortByDistance(BigDecimal longitude, BigDecimal latitude, Integer num);
}
