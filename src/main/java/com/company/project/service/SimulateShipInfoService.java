package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.SimulateShipInfo;
import com.company.project.model.other.SimulateShipInfoIdLongLat;

import java.util.List;


/**
 * Created by CodeGenerator on 2019/07/26.
 */
public interface SimulateShipInfoService extends Service<SimulateShipInfo> {
    Integer simulateCH02601(Integer mmsi,Integer idPoint);
    Integer simulateShipUpdatePosition(String shipTrack,Integer mmsi,Integer idPoint);
    List<SimulateShipInfoIdLongLat> getIdLongLat();

    List<Double> getLong();
    List<Double> getLat();
    Integer rowCount();
    Integer updateAngleSpeed(String angleString,String speedString ,Integer id);

    int[] getIdInit(int shipNum, int amount);
    int[] getSpeed(int speedMax, int speedMin, int shipNum);
    Double[] getLongArray();
    Double[] getLatArray();
    double getAngle( double lng_a,double lat_a, double lng_b,double lat_b );
    double getSpeed( double lng_a,double lat_a, double lng_b,double lat_b);

    Integer updateLongLatAngleSpeed(double longitude,
                                    double latitude,
                                    String angleString,
                                     String speedString,
                                    Integer id);

    Integer insertLongLatAngleSpeedToStatic(double longitude,
                                            double latitude,
                                            String angleString,
                                            String speedString,
                                            Integer id);
//    Integer updateCH02601(Integer divisor, Integer remainder,Integer subtract);

}
