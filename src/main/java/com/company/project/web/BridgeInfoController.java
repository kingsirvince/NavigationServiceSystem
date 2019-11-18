package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.BridgeInfo;
import com.company.project.model.distance.BridgeInfoDistance;
import com.company.project.model.other.BridgeInfoHeight;
import com.company.project.service.BridgeInfoService;
import com.company.project.service.ShipMonitorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
* Created by CodeGenerator on 2019/08/12.
*/
@RestController
@RequestMapping("/bridge/info")
public class BridgeInfoController {
    @Resource
    private BridgeInfoService bridgeInfoService;
    //得用载入来调用service的方法
    @Autowired
    private ShipMonitorService shipMonitorService;
    /**
     *
     * 查询某列某行的单值  （模拟限高）
     * @param field   列名 Bridge_limit_height
     * @param row      行名 Bridge_name
     * @param rowValue 值 太子塘桥
     *                 field=Bridge_limit_height&row=Bridge_name&rowValue=太子塘桥
     *                 field=Bridge_limit_height&row=Bridge_ID&rowValue=JXCH026HD0017QL009
     * @return
     */
    @PostMapping("/getByRowField")
    public Result getByRowField(@RequestParam String field,@RequestParam String row,@RequestParam String rowValue,@RequestParam(defaultValue = "requestId:0") String requestId) {
       Double s = bridgeInfoService.getByRowField(field, row, rowValue);

//       //监控记录
//        String monitorLog = "查询请求： requestId= " + requestId + " ,在航状态= " + shipState + " ,经度= " + shipLongitude + " ,维度= " + shipLatitude + " ; ";
//        System.out.println("****************  " + monitorLog + "   ****************  ");
//        //写入到ship_monitor表中
//        ShipMonitor shipMonitor = new ShipMonitor();
//        shipMonitor.setMonitorlog(monitorLog);
//        shipMonitor.setType("shipUpload");
//
//
//        shipMonitorService.save(shipMonitor);


        return ResultGenerator.genSuccessResult(s);
    }

    /**
     * 按条件查询   (例如查询“梧桐作业区“）
     * @param fieldName  代表字段名（Model中的成员变量，DockInfo）   fieldName=dockName
     * @param value      可以不是唯一的（返回多个List）              value=梧桐作业区
     */
    @PostMapping("/findByCondition")
    public Result findByCondition(@RequestParam String fieldName, @RequestParam Object value,@RequestParam(defaultValue = "requestId:0") String requestId) {

        Condition condition = new Condition(BridgeInfo.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.orEqualTo(fieldName, value);

        List<BridgeInfo> list = bridgeInfoService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
    /**
     * 按距离排序：  输入经纬度和需要返回数量，返回按距离最近的num个记录
     * @param longitude
     * @param latitude
     * @param num   需要返回数量（可以不写，默认是5个）
     * @return
     */
    @PostMapping("/sortByDistance")
    public Result sortByDistance(@RequestParam("longitude") BigDecimal longitude, @RequestParam ("latitude")BigDecimal latitude, @RequestParam(value = "num",defaultValue ="5" )Integer num ,@RequestParam(defaultValue = "requestId:0") String requestId){
        List<BridgeInfoDistance> list = bridgeInfoService.sortByDistance(longitude, latitude,num);
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 得到限高列表 （名字、ID、限高）
     * @return
     */
    @PostMapping("/getLimitHeight")
    public Result getLimitHeight(@RequestParam(defaultValue = "requestId:0") String requestId){
        List<BridgeInfoHeight> list =bridgeInfoService.getLimitHeight();
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/add")
    public Result add(BridgeInfo bridgeInfo,@RequestParam(defaultValue = "requestId:0") String requestId) {
        bridgeInfoService.save(bridgeInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        bridgeInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(BridgeInfo bridgeInfo,@RequestParam(defaultValue = "requestId:0") String requestId) {
        bridgeInfoService.update(bridgeInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        BridgeInfo bridgeInfo = bridgeInfoService.findById(id);
        return ResultGenerator.genSuccessResult(bridgeInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "requestId:0") String requestId) {
        PageHelper.startPage(page, size);
        List<BridgeInfo> list = bridgeInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
