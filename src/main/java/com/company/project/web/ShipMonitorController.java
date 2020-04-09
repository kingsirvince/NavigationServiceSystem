package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.ShipHistory;
import com.company.project.model.ShipMonitor;
import com.company.project.service.ShipMonitorService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/11/01.
*/
@RestController
@RequestMapping("/ship/monitor")
public class ShipMonitorController {
    @Resource
    private ShipMonitorService shipMonitorService;

    /**
     * 查询最新的num条记录
     * @param num   默认值defaultValue = 15
     * @param page  分页参数，默认 0，即全部显示
     * @param size  分页参数，默认 0
     * @return
     */
    @PostMapping("/findSeveralMonitor")
    public Result findSeveralMonitor(@RequestParam(defaultValue = "15") Integer num,@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "requestId:0") String requestId) {
        PageHelper.startPage(page, size);
        List<ShipMonitor> list = shipMonitorService.findSeveralMonitor(num);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 查询最新的num个记录，满足种类是typeName（条件 Type=typeName）
     * @param num
     * @param typeName  Type是什么
     * @param page
     * @param size
     *               SELECT * FROM ship_monitor WHERE  Type = #{typeName}   ORDER BY ID desc limit #{num};
     * @return
     */
    @PostMapping("/findSeveralByType")
    public Result findSeveralByType(@RequestParam(defaultValue = "15") Integer num, @RequestParam String typeName, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "requestId:0") String requestId) {
        PageHelper.startPage(page, size);
        List<ShipMonitor> list = shipMonitorService.findSeveralByType(num, typeName);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 查询最新的num个，满足请求ID是selectRequestId（条件 RequestID = #{selectRequestId}
     * @param num
     * @param selectRequestId   查询的RequestId
     * @param page
     * @param size
     * @param requestId   访问监控用的请求ID
     * @return
     */
    @PostMapping("/findSeveralByRequestId")
    public Result findSeveralByRequestId(@RequestParam(defaultValue = "15") Integer num, @RequestParam String selectRequestId, @RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "requestId:0") String requestId) {
        PageHelper.startPage(page, size);
        List<ShipMonitor> list = shipMonitorService.findSeveralByRequestId(num, selectRequestId);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    /**
     * 条件查询，可以是时间段之间的记录 where fieldName between value1 and value2
     * @param fieldName 代表字段名（Model中的成员变量） 选datetime即是时间
     * @param value1    在1 和 2 之间
     * @param value2
     * @return          List
     */
    @PostMapping("/findByBetween")
    public Result findByBetween(@RequestParam String fieldName, @RequestParam Object value1,@RequestParam Object value2,@RequestParam(defaultValue = "requestId:0") String requestId) {

        Condition condition = new Condition(ShipHistory.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andBetween(fieldName,value1,value2);

        List<ShipMonitor> list = shipMonitorService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }


    @PostMapping("/add")
    public Result add(ShipMonitor shipMonitor,@RequestParam(defaultValue = "requestId:0") String requestId) {
        shipMonitorService.save(shipMonitor);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        shipMonitorService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ShipMonitor shipMonitor,@RequestParam(defaultValue = "requestId:0") String requestId) {
        shipMonitorService.update(shipMonitor);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        ShipMonitor shipMonitor = shipMonitorService.findById(id);
        return ResultGenerator.genSuccessResult(shipMonitor);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "requestId:0") String requestId) {
        PageHelper.startPage(page, size);
        List<ShipMonitor> list = shipMonitorService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
