package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.SimulateShipInfoMapper;
import com.company.project.model.SimulateShipInfo;
import com.company.project.model.other.SimulateShipInfoIdLongLat;
import com.company.project.service.SimulateShipInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/07/26.
 */
@Service
@Transactional
public class SimulateShipInfoServiceImpl extends AbstractService<SimulateShipInfo> implements SimulateShipInfoService {
    @Resource
    private SimulateShipInfoMapper simulateShipInfoMapper;

    @Override
    public Integer simulateCH02601(Integer mmsi, Integer idPoint) {
        return simulateShipInfoMapper.simulateCH02601(mmsi,idPoint);
    }

    @Override
    public Integer simulateShipUpdatePosition(String shipTrack, Integer mmsi, Integer idPoint) {
        return simulateShipInfoMapper.simulateShipUpdatePosition(shipTrack, mmsi, idPoint);
    }

    @Override
    public List<SimulateShipInfoIdLongLat> getIdLongLat() {
        return simulateShipInfoMapper.getIdLongLat();
    }

    @Override
    public List<Double> getLong() {
        return simulateShipInfoMapper.getLong();
    }

    @Override
    public List<Double> getLat() {
        return simulateShipInfoMapper.getLat();
    }

    @Override
    public Integer rowCount() {
        return simulateShipInfoMapper.rowCount();
    }

    @Override
    public Integer updateAngleSpeed(String angleString,String speedString ,Integer id) {
        return simulateShipInfoMapper.updateAngleSpeed(angleString,speedString, id);
    }

    /* @Override
    public Integer updateCH02601(Integer divisor, Integer remainder , Integer subtract) {
        return simulateShipInfoMapper.updateCH02601(divisor, remainder,subtract);
    }*/
}
