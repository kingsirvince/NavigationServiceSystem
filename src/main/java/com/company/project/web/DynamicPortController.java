package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.DynamicPort;
import com.company.project.service.DynamicPortService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/07/31.
*/
@RestController
@RequestMapping("/dynamic/port")
public class DynamicPortController {
    @Resource
    private DynamicPortService dynamicPortService;

    @PostMapping("/add")
    public Result add(DynamicPort dynamicPort) {
        dynamicPortService.save(dynamicPort);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        dynamicPortService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(DynamicPort dynamicPort) {
        dynamicPortService.update(dynamicPort);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        DynamicPort dynamicPort = dynamicPortService.findById(id);
        return ResultGenerator.genSuccessResult(dynamicPort);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<DynamicPort> list = dynamicPortService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/updateDynamicPortBetweenId")
    public Result updateDynamicPortBetweenId(@RequestParam Integer id1, @RequestParam Integer id2) {
        dynamicPortService.updateDynamicPortBetweenId(id1, id2);
        return ResultGenerator.genSuccessResult();

    }
}
