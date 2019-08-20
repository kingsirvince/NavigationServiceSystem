package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.FloodgateInfo;
import com.company.project.model.distance.FloodgateInfoDistance;
import com.company.project.service.FloodgateInfoService;
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
@RequestMapping("/floodgate/info")
public class FloodgateInfoController {
    @Resource
    private FloodgateInfoService floodgateInfoService;

    /**
     * 按条件查询   (例如查询“梧桐作业区“）
     * @param fieldName  代表字段名（Model中的成员变量，DockInfo）   fieldName=dockName
     * @param value      可以不是唯一的（返回多个List）              value=梧桐作业区
     */
    @PostMapping("/findByCondition")
    public Result findByCondition(@RequestParam String fieldName, @RequestParam Object value) {

        Condition condition = new Condition(FloodgateInfo.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.orEqualTo(fieldName, value);

        List<FloodgateInfo> list = floodgateInfoService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/sortByDistance")
    public Result sortByDistance(@RequestParam BigDecimal longitude,@RequestParam BigDecimal latitude,@RequestParam(value = "num" ,defaultValue = "5" ) Integer num){
        List<FloodgateInfoDistance> list = floodgateInfoService.sortByDistance(longitude, latitude, num);
        return  ResultGenerator.genSuccessResult(list);
    }
    @PostMapping("/add")
    public Result add(FloodgateInfo floodgateInfo) {
        floodgateInfoService.save(floodgateInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        floodgateInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(FloodgateInfo floodgateInfo) {
        floodgateInfoService.update(floodgateInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        FloodgateInfo floodgateInfo = floodgateInfoService.findById(id);
        return ResultGenerator.genSuccessResult(floodgateInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<FloodgateInfo> list = floodgateInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
