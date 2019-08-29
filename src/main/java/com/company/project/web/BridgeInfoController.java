package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.BridgeInfo;
import com.company.project.model.distance.BridgeInfoDistance;
import com.company.project.service.BridgeInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    /**
     * 查询某列某行的单值  （模拟限高）
     * @param field   列名 Bridge_limit_height
     * @param row      行名 Bridge_name
     * @param rowValue 值 太子塘桥
     * @return
     */
    @PostMapping("/getByRowField")
    public Result getByRowField(@RequestParam String field,@RequestParam String row,@RequestParam String rowValue) {
       Double s = bridgeInfoService.getByRowField(field, row, rowValue);
        return ResultGenerator.genSuccessResult(s);
    }

    /**
     * 按条件查询   (例如查询“梧桐作业区“）
     * @param fieldName  代表字段名（Model中的成员变量，DockInfo）   fieldName=dockName
     * @param value      可以不是唯一的（返回多个List）              value=梧桐作业区
     */
    @PostMapping("/findByCondition")
    public Result findByCondition(@RequestParam String fieldName, @RequestParam Object value) {

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
    @PostMapping("sortByDistance")
    public Result sortByDistance(@RequestParam("longitude") BigDecimal longitude, @RequestParam ("latitude")BigDecimal latitude, @RequestParam(value = "num",defaultValue ="5" )Integer num ){
        List<BridgeInfoDistance> list = bridgeInfoService.sortByDistance(longitude, latitude,num);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/add")
    public Result add(BridgeInfo bridgeInfo) {
        bridgeInfoService.save(bridgeInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        bridgeInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(BridgeInfo bridgeInfo) {
        bridgeInfoService.update(bridgeInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        BridgeInfo bridgeInfo = bridgeInfoService.findById(id);
        return ResultGenerator.genSuccessResult(bridgeInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<BridgeInfo> list = bridgeInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
