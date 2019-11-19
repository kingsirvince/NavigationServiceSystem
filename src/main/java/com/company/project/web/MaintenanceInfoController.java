package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.MaintenanceInfo;
import com.company.project.model.distance.MaintenanceInfoDistance;
import com.company.project.service.MaintenanceInfoService;
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
@RequestMapping("/maintenance/info")
public class MaintenanceInfoController {
    @Resource
    private MaintenanceInfoService maintenanceInfoService;

    /**
     * 按条件查询   (例如查询“梧桐作业区“）
     * @param fieldName  代表字段名（Model中的成员变量，DockInfo）   fieldName=dockName
     * @param value      可以不是唯一的（返回多个List）              value=梧桐作业区
     */
    @PostMapping("/findByCondition")
    public Result findByCondition(@RequestParam String fieldName, @RequestParam Object value,@RequestParam(defaultValue = "requestId:0") String requestId) {

        Condition condition = new Condition(MaintenanceInfo.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.orEqualTo(fieldName, value);

        List<MaintenanceInfo> list = maintenanceInfoService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/sortByDistance")
    public Result sortByDistance(@RequestParam BigDecimal longitude, @RequestParam BigDecimal latitude, @RequestParam(defaultValue = "5") Integer num,@RequestParam(defaultValue = "requestId:0") String requestId) {
        List<MaintenanceInfoDistance> list = maintenanceInfoService.sortByDistance(longitude, latitude, num);
        return ResultGenerator.genSuccessResult(list);

    }
    @PostMapping("/add")
    public Result add(MaintenanceInfo maintenanceInfo,@RequestParam(defaultValue = "requestId:0") String requestId) {
        maintenanceInfoService.save(maintenanceInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        maintenanceInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(MaintenanceInfo maintenanceInfo,@RequestParam(defaultValue = "requestId:0") String requestId) {
        maintenanceInfoService.update(maintenanceInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        MaintenanceInfo maintenanceInfo = maintenanceInfoService.findById(id);
        return ResultGenerator.genSuccessResult(maintenanceInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "requestId:0") String requestId) {
        PageHelper.startPage(page, size);
        List<MaintenanceInfo> list = maintenanceInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
