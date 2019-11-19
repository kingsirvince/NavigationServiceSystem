//package com.company.project.web;
//
//import com.company.project.core.Result;
//import com.company.project.core.ResultGenerator;
//import com.company.project.model.Tabledynamic;
//import com.company.project.service.TabledynamicService;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import org.apache.ibatis.exceptions.TooManyResultsException;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import tk.mybatis.mapper.entity.Condition;
//import tk.mybatis.mapper.entity.Example;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
//* Created by CodeGenerator on 2019/07/05.
//*/
//@RestController
//@RequestMapping("/tabledynamic")
//public class TabledynamicController {
//    @Resource
//    private TabledynamicService tabledynamicService;
//
//    @PostMapping("/add")
//    public Result add(Tabledynamic tabledynamic) {
//        tabledynamicService.save(tabledynamic);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        tabledynamicService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(Tabledynamic tabledynamic) {
//        tabledynamicService.update(tabledynamic);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        Tabledynamic tabledynamic = tabledynamicService.findById(id);
//        return ResultGenerator.genSuccessResult(tabledynamic);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<Tabledynamic> list = tabledynamicService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
//
//
//    /**
//     * 查询按Ids 多条返回
//     * @param ids   例如 ids=1,2,3,4   String格式
//     * @return      多条返回
//     */
//    @PostMapping("/findByIds")
//    public Result findByIds(@RequestParam String ids) {
//        List<Tabledynamic> list = tabledynamicService.findByIds(ids);
//        return ResultGenerator.genSuccessResult(list);
//    }
//
//    /**
//     * 按条件查询  select from tableship WHERE fieldName=value，返回单个数据
//     * @param fieldName  代表字段名（Model中的成员变量，Tableship）
//     * @param value      必须是唯一的（返回单个）
//     * @return
//     * @throws TooManyResultsException
//     */
//    @PostMapping("/findBy")
//    public Result findBy(@RequestParam String fieldName, @RequestParam Object value) throws TooManyResultsException {
//        Tabledynamic tabledynamic = tabledynamicService.findBy(fieldName, value);
//        return ResultGenerator.genSuccessResult(tabledynamic);
//    }
//
//
//    /**
//     * 按条件查询
//     * @param fieldName  代表字段名（Model中的成员变量，Tableship）
//     * @param value      可以不是唯一的（返回多个List）
//     */
//    @PostMapping("/findByCondition")
//    public Result findByCondition(@RequestParam String fieldName, @RequestParam Object value) {
//
//        Condition condition = new Condition(Tabledynamic.class);
//        Example.Criteria criteria = condition.createCriteria();
//        criteria.orEqualTo(fieldName, value);
//
//        List<Tabledynamic> list = tabledynamicService.findByCondition(condition);
//        return ResultGenerator.genSuccessResult(list);
//    }
//
//    /**
//     * 按2个条件查询  (例如：航道划分=10010，时间=2019-06-27 16:50:50）
//     *      * sql: select * from tableship where fieldName=value and fieldName1=value2
//     * @param fieldName     字段名1 fieldName=channelDivisionId ,  value=10010
//     * @param value
//     * @param fieldName1    字段名2 fieldName1=datatime, value2=2019-06-27 16:50:50
//     * @param value1
//     * @return
//     */
//    @PostMapping("/findByCondition2")
//    public Result findByCondition2(@RequestParam String fieldName, @RequestParam Object value,
//                                   @RequestParam String fieldName1, @RequestParam Object value1) {
//
//        Condition condition = new Condition(Tabledynamic.class);
//        Example.Criteria criteria = condition.createCriteria();
//        criteria.andEqualTo(fieldName, value);
//        criteria.andEqualTo(fieldName1, value1);
//        List<Tabledynamic> list = tabledynamicService.findByCondition(condition);
//        return ResultGenerator.genSuccessResult(list);
//    }
//
//
//    /**
//     * 按条件查询(例如：航道划分=10010，uuid在1~200之间）
//     * sql: select * from tableship where fieldName=value and fieldName1 between value1 and value2
//     * @param fieldName       fieldName=value ->  channelDivisionId=10010
//     * @param value                 fieldName=channelDivisionId ,  value=10010
//     * @param fieldName1      fieldName1 between value1 and value2   ->  uuid between 1 and 20
//     * @param value1                fieldName1=uuid , value1=1, value2=200
//     * @param value2
//     * @return                查询到的所有船记录 List
//     */
//    @PostMapping("/findByConditionBetween")
//    public Result findByConditionBetween(@RequestParam String fieldName, @RequestParam Object value,
//                                         @RequestParam String fieldName1, @RequestParam Object value1,@RequestParam Object value2) {
//
//        Condition condition = new Condition(Tabledynamic.class);
//        Example.Criteria criteria = condition.createCriteria();
//        criteria.orEqualTo(fieldName, value);
//        criteria.andBetween(fieldName1, value1,value2);
//        List<Tabledynamic> list = tabledynamicService.findByCondition(condition);
//        return ResultGenerator.genSuccessResult(list);
//    }
//
//    /**
//     * 条件查询，where fieldName between value1 and value2
//     * @param fieldName 代表字段名（Model中的成员变量）
//     * @param value1    在1 和 2 之间
//     * @param value2
//     * @return          List
//     */
//    @PostMapping("/findByBetween")
//    public Result findByBetween(@RequestParam String fieldName, @RequestParam Object value1,@RequestParam Object value2) {
//
//        Condition condition = new Condition(Tabledynamic.class);
//        Example.Criteria criteria = condition.createCriteria();
//        criteria.andBetween(fieldName,value1,value2);
//
//        List<Tabledynamic> list = tabledynamicService.findByCondition(condition);
//        return ResultGenerator.genSuccessResult(list);
//    }
//}
