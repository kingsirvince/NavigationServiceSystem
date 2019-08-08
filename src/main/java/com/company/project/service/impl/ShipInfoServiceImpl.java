package com.company.project.service.impl;

import com.company.project.core.AbstractService;
import com.company.project.dao.ShipInfoMapper;
import com.company.project.model.ShipInfo;
import com.company.project.service.ShipInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/07/26.
 */
@Service
@Transactional
public class ShipInfoServiceImpl extends AbstractService<ShipInfo> implements ShipInfoService {
    @Resource
    private ShipInfoMapper shipInfoMapper;


    @Override
    public Integer updateShipInfoBetweenId(Integer id1, Integer id2) {
        return shipInfoMapper.updateShipInfoBetweenId(id1, id2);
    }
}

//失败方案：只能返回model中值，不能得到mysql中的所有值
 /*   @Override
    public List<ShipInfo> nearbyShip(Integer MMSI) {
//计算得到上传船舶的航道划分：shipUpload.getChannelDivisionId()
//计算得到周边航道划分数组：nearbyChannelDivisionID
//        ShipUploadServiceImpl shipUploadService = (ShipUploadServiceImpl) SpringContextUtil.getBean(ShipUploadServiceImpl.class);
//        String channelDivisionID = shipUploadMapper.getChannelDivisionID(MMSI);
//
//        String channelDivisionID = MapperUtil.getShipUploadCDID(MMSI);
//        System.out.println("%%%%%%%%% ShipUpload当前船舶 航道划分："+channelDivisionID+"%%%%%%%%%");
//
//        String[] nearbyChannelDivisionID = ChannelDivisionIDUtil.getNearbyChannelDivisionID(channelDivisionID);
//
//        String nearbyChannelDivisionID1= nearbyChannelDivisionID[0];
//        String nearbyChannelDivisionID2= nearbyChannelDivisionID[1];
//        String nearbyChannelDivisionID3= nearbyChannelDivisionID[2];
//        String nearbyChannelDivisionID4= nearbyChannelDivisionID[3];
//        String nearbyChannelDivisionID5= nearbyChannelDivisionID[4];
//
//        for (int i=0;i<nearbyChannelDivisionID.length;i++){
//            System.out.println("$$$$$$$$$$$$$$$$$$$--ShipInfo 周围航道划分【数组】："+nearbyChannelDivisionID[i]);}

/*        System.out.println("——————赋值传给sql——————");
        System.out.println("nearbyChannelDivisionID1:"+nearbyChannelDivisionID1);
        System.out.println("nearbyChannelDivisionID2:"+nearbyChannelDivisionID2);
        System.out.println("nearbyChannelDivisionID3:"+nearbyChannelDivisionID3);
        System.out.println("nearbyChannelDivisionID4:"+nearbyChannelDivisionID4);
        System.out.println("nearbyChannelDivisionID5:"+nearbyChannelDivisionID5);*/


//        return shipInfoMapper.nearbyShip(nearbyChannelDivisionID1,nearbyChannelDivisionID2,nearbyChannelDivisionID3,nearbyChannelDivisionID4,nearbyChannelDivisionID5);
