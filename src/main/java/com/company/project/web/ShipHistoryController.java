package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.ShipHistory;
import com.company.project.service.ShipHistoryService;
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
* Created by CodeGenerator on 2019/08/14.
*/
@RestController
@RequestMapping("/ship/history")
public class ShipHistoryController {
    @Resource
    private ShipHistoryService shipHistoryService;

    @PostMapping("/add")
    public Result add(ShipHistory shipHistory) {
        shipHistoryService.save(shipHistory);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        shipHistoryService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ShipHistory shipHistory) {
        shipHistoryService.update(shipHistory);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        ShipHistory shipHistory = shipHistoryService.findById(id);
        return ResultGenerator.genSuccessResult(shipHistory);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ShipHistory> list = shipHistoryService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }


    /**
     * 按条件查询
     * @param fieldName  代表字段名（Model中的成员变量，Tableship）
     * @param value      可以不是唯一的（返回多个List）
     */
    @PostMapping("/findByCondition")
    public Result findByCondition(@RequestParam String fieldName, @RequestParam Object value) {

        Condition condition = new Condition(ShipHistory.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.orEqualTo(fieldName, value);

        List<ShipHistory> list = shipHistoryService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 按2个条件查询  (例如：航道划分=10010，时间=2019-06-27 16:50:50）
     *      * sql: select * from tableship where fieldName=value and fieldName1=value2
     * @param fieldName     字段名1 fieldName=channelDivisionId ,  value=10010
     * @param value
     * @param fieldName1    字段名2 fieldName1=datatime, value2=2019-06-27 16:50:50
     * @param value1
     * @return
     */
    @PostMapping("/findByCondition2")
    public Result findByCondition2(@RequestParam String fieldName, @RequestParam Object value,
                                   @RequestParam String fieldName1, @RequestParam Object value1) {

        Condition condition = new Condition(ShipHistory.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo(fieldName, value);
        criteria.andEqualTo(fieldName1, value1);
        List<ShipHistory> list = shipHistoryService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }


    /**
     * 按条件查询(例如：时间段内历史记录查询）
     * sql: select * from tableship where fieldName=value and fieldName1 between value1 and value2
     * @param fieldName       fieldName=value ->  channelDivisionId=10010
     * @param value                 fieldName=shipMmsi ,  value=55555551
     * @param fieldName1      fieldName1 between value1 and value2   ->  uuid between 1 and 20
     * @param value1                fieldName1=datetime , value1=2019-08-13 09:20:02, value2=2019-08-13 10:50:02
     * @param value2
     * @return                查询到时间段内历史记录查询 List
     */
    @PostMapping("/findByConditionBetween")
    public Result findByConditionBetween(@RequestParam String fieldName, @RequestParam Object value,
                                         @RequestParam String fieldName1, @RequestParam Object value1,@RequestParam Object value2) {

        Condition condition = new Condition(ShipHistory.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.orEqualTo(fieldName, value);
        criteria.andBetween(fieldName1, value1,value2);
        List<ShipHistory> list = shipHistoryService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 条件查询，where fieldName between value1 and value2
     * @param fieldName 代表字段名（Model中的成员变量，Tableship）
     * @param value1    在1 和 2 之间
     * @param value2
     * @return          List
     */
    @PostMapping("/findByBetween")
    public Result findByBetween(@RequestParam String fieldName, @RequestParam Object value1,@RequestParam Object value2) {

        Condition condition = new Condition(ShipHistory.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andBetween(fieldName,value1,value2);

        List<ShipHistory> list = shipHistoryService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }
}
