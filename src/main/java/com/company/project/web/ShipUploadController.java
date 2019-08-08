package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.ShipUpload;
import com.company.project.service.ShipUploadService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/08/07.
*/
@RestController
@RequestMapping("/ship/upload")
public class ShipUploadController {
    @Resource
    private ShipUploadService shipUploadService;

    @PostMapping("/add")
    public Result add(ShipUpload shipUpload) {
        shipUploadService.save(shipUpload);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        shipUploadService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ShipUpload shipUpload) {
        shipUploadService.update(shipUpload);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        ShipUpload shipUpload = shipUploadService.findById(id);
        return ResultGenerator.genSuccessResult(shipUpload);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ShipUpload> list = shipUploadService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/getChannelDivisionID")
    public Result getChannelDivisionID(@RequestParam Integer MMSI) {
        String channelDivisionID = shipUploadService.getChannelDivisionID(MMSI);
        return ResultGenerator.genSuccessResult(channelDivisionID);
    }

    /*
    *//**
     * 按2个条件查询  (例如：航道划分=10010，时间=2019-06-27 16:50:50）
     *      * sql: select * from tableship where fieldName=value and fieldName1=value2
     * @param fieldName     字段名1 fieldName=channelDivisionId ,  value=10010
     * @param value
     * @param fieldName1    字段名2 fieldName1=datatime, value2=2019-06-27 16:50:50
     * @param value1
     * @return
     *//*
    @PostMapping("/findByCondition2")
    public Result findByCondition2(@RequestParam String fieldName, @RequestParam Object value,
                                   @RequestParam String fieldName1, @RequestParam Object value1) {

        Condition condition = new Condition(ShipUpload.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo(fieldName, value);
        criteria.andEqualTo(fieldName1, value1);
        List<ShipUpload> list = shipUploadService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }*/
}
