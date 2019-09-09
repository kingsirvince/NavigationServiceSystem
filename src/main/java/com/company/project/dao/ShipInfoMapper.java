package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.ShipInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ShipInfoMapper extends Mapper<ShipInfo> {
    //Integer updateShipInfoBetweenId(@Param("id1")Integer id1, @Param("id2")Integer id2);

    List<ShipInfo> findAllIncludeStaticShip();

    List<ShipInfo> getVicinity(@Param("minlng") BigDecimal minlng,
                                   @Param("maxlng") BigDecimal maxlng,
                                   @Param("minlat") BigDecimal minlat,
                                   @Param("maxlat") BigDecimal maxlat);

    Integer updateToShipInfoFromStatic(@Param("uid1" )int uid1,@Param("uid2")int uid2);



//    List<com.company.project.model.ShipInfo> nearbyShip(@Param("nearbyChannelDivisionID1")String nearbyChannelDivisionID1, @Param("nearbyChannelDivisionID2")String nearbyChannelDivisionID2, @Param("nearbyChannelDivisionID3")String nearbyChannelDivisionID3, @Param("nearbyChannelDivisionID4")String nearbyChannelDivisionID4, @Param("nearbyChannelDivisionID5")String nearbyChannelDivisionID5);
}