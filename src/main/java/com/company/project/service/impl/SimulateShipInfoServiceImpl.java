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
import java.util.Random;


/**
 * Created by CodeGenerator on 2019/07/26.
 */
@Resource
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

    /**
     * 原SimulateUtil中方法移植到此处service
     */

    Random ran = new Random();

    /**
     * 得到初始点位（航迹的哪一行）
     * @param shipNum
     * @param amount
     * @return
     */
    public int[] getIdInit(int shipNum, int amount) {

        int[] idInit = new int[shipNum];
        for (int i = 0; i < shipNum; i++) {
            idInit[i] = ran.nextInt(amount);
            System.out.println(idInit[i]);
        }
        return idInit;
    }

    /**
     * 得到速度
     * @param speedMax
     * @param speedMin
     * @param shipNum
     * @return
     */
    public int[] getSpeed(int speedMax, int speedMin, int shipNum) {
        int[] speed = new int[shipNum];
        for (int i = 0; i < shipNum; i++) {
            speed[i] = ran.nextInt(speedMax - speedMin + 1) + speedMin;
            System.out.println(speed[i]);
        }
        return speed;
    }

    /**
     * 将经度从mysql返回的list中，提取到数组getLong中
     * @return
     */
    public Double[] getLongArray() {
        List<Double> listLong = getLong();

        //list赋值给数组   list.toArray
        Double[] getLong = new Double[listLong.size()];
        listLong.toArray(getLong);
        return getLong;
    }


    public Double[] getLatArray() {
        List<Double> listLat = getLat();
        Double[] getLat = new Double[listLat.size()];
        listLat.toArray(getLat);
        return getLat;
    }


    /**
     *算角度
     * @param lat_a 纬度1
     * @param lng_a 经度1
     * @param lat_b 纬度2
     * @param lng_b 经度2
     * @return
     */
    public   double getAngle( double lng_a,double lat_a, double lng_b,double lat_b ) {

        double y = Math.sin(lng_b - lng_a) * Math.cos(lat_b);
        double x = Math.cos(lat_a) * Math.sin(lat_b) - Math.sin(lat_a) * Math.cos(lat_b) * Math.cos(lng_b - lng_a);
        double brng = Math.atan2(y, x);

        brng = Math.toDegrees(brng);
        if (brng < 0)
            brng = brng + 360;
        return brng;

    }

    /**
     * 算速度
     */
    public double getSpeed( double lng_a,double lat_a, double lng_b,double lat_b) {
        double x = Math.pow((lng_b - lng_a),2);
        double y = Math.pow((lat_b - lat_a), 2);
        double speed= Math.sqrt(x+y)*111322.2222*3600/1000/1.825;
        return speed;
    }

    /**
     * 根据id更新 经纬度、角度、速度
     * @param longitude
     * @param latitude
     * @param angleString
     * @param speedString
     * @param id
     * @return
     */
    @Override
    public Integer updateLongLatAngleSpeed(double longitude, double latitude, String angleString, String speedString, Integer id) {
        return simulateShipInfoMapper.updateLongLatAngleSpeed(longitude, latitude, angleString, speedString, id);
    }

    @Override
    public Integer insertLongLatAngleSpeedToStatic(double longitude, double latitude, String angleString, String speedString, Integer id) {
        return simulateShipInfoMapper.insertLongLatAngleSpeedToStatic(longitude, latitude, angleString, speedString, id);
    }
/* @Override
    public Integer updateCH02601(Integer divisor, Integer remainder , Integer subtract) {
        return simulateShipInfoMapper.updateCH02601(divisor, remainder,subtract);
    }*/
}
