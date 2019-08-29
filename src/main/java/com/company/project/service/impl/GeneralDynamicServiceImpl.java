package com.company.project.service.impl;

import com.company.project.dao.GeneralDynamicMapper;
import com.company.project.model.GeneralDynamic;
import com.company.project.model.distance.GeneralDynamicDistance;
import com.company.project.service.GeneralDynamicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/20.
 */
@Service
@Transactional
public class GeneralDynamicServiceImpl  implements GeneralDynamicService {
    @Resource
    private GeneralDynamicMapper generalDynamicMapper;

    @Override
    public List<GeneralDynamic> getBerth() {
        return generalDynamicMapper.getBerth();
    }

    @Override
    public List<GeneralDynamicDistance> berthSortByDistance(BigDecimal longitude, BigDecimal latitude, Integer num) {
        return generalDynamicMapper.berthSortByDistance(longitude, latitude, num);
    }

    @Override
    public List<GeneralDynamic> getCharger() {
        return generalDynamicMapper.getCharger();
    }

    @Override
    public List<GeneralDynamicDistance> chargerSortByDistance(BigDecimal longitude, BigDecimal latitude, Integer num) {
        return generalDynamicMapper.chargerSortByDistance(longitude, latitude, num);
    }

    @Override
    public List<GeneralDynamic> getRecycling() {
        return generalDynamicMapper.getRecycling();
    }

    @Override
    public List<GeneralDynamicDistance> recyclingSortByDistance(BigDecimal longitude, BigDecimal latitude, Integer num) {
        return generalDynamicMapper.recyclingSortByDistance(longitude, latitude, num);
    }

    @Override
    public List<GeneralDynamic> getGas() {
        return generalDynamicMapper.getGas();
    }

    @Override
    public List<GeneralDynamicDistance> gasSortByDistance(BigDecimal longitude, BigDecimal latitude, Integer num) {
        return generalDynamicMapper.gasSortByDistance(longitude, latitude, num);
    }
}
