package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.PipelineInfo;
import com.company.project.model.distance.PipelineInfoDistance;
import com.company.project.model.other.PipelineInfoHeight;
import com.company.project.service.PipelineInfoService;
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
@RequestMapping("/pipeline/info")
public class PipelineInfoController {
    @Resource
    private PipelineInfoService pipelineInfoService;

    /**
     * 查询某列某行的单值  （模拟限高）
     * @param field   列名 Pipeline_limit_height
     * @param row      行名 Pipeline_name
     * @param rowValue 值 乍嘉苏跨河管线01
     * @return
     */
    @PostMapping("/getByRowField")
    public Result getByRowField(@RequestParam String field,@RequestParam String row,@RequestParam String rowValue) {
        Double s = pipelineInfoService.getByRowField(field, row, rowValue);
        return ResultGenerator.genSuccessResult(s);
    }
    /**
     * 按条件查询   (例如查询“梧桐作业区“）
     * @param fieldName  代表字段名（Model中的成员变量，DockInfo）   fieldName=dockName
     * @param value      可以不是唯一的（返回多个List）              value=梧桐作业区
     */
    @PostMapping("/findByCondition")
    public Result findByCondition(@RequestParam String fieldName, @RequestParam Object value) {

        Condition condition = new Condition(PipelineInfo.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.orEqualTo(fieldName, value);

        List<PipelineInfo> list = pipelineInfoService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 得到限高列表 （名字、ID、限高）
     * @return
     */
    @PostMapping("/getLimitHeight")
    public Result getLimitHeight(){
        List<PipelineInfoHeight> list =pipelineInfoService.getLimitHeight();
        return ResultGenerator.genSuccessResult(list);
    }

    @PostMapping("/sortByDistance")
    public Result sortByDistance(@RequestParam BigDecimal longitude,@RequestParam BigDecimal latitude,@RequestParam(defaultValue = "5")Integer num) {
        List<PipelineInfoDistance> list = pipelineInfoService.sortByDistance(longitude, latitude, num);
        return ResultGenerator.genSuccessResult(list);
    }
    @PostMapping("/add")
    public Result add(PipelineInfo pipelineInfo) {
        pipelineInfoService.save(pipelineInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        pipelineInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(PipelineInfo pipelineInfo) {
        pipelineInfoService.update(pipelineInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        PipelineInfo pipelineInfo = pipelineInfoService.findById(id);
        return ResultGenerator.genSuccessResult(pipelineInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<PipelineInfo> list = pipelineInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
