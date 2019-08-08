package com.company.project.service.impl;

import com.company.project.dao.ShipUploadMapper;
import com.company.project.model.ShipUpload;
import com.company.project.service.ShipUploadService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/08/07.
 */
@Service
@Transactional
public class ShipUploadServiceImpl extends AbstractService<ShipUpload> implements ShipUploadService {
    @Resource
    private ShipUploadMapper shipUploadMapper;

    @Override
    public String getChannelDivisionID(Integer MMSI) {


        return shipUploadMapper.getChannelDivisionID(MMSI);
    }
}
