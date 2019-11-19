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

/**非对外，内部模拟动态设施
* Created by CodeGenerator on 2019/07/31.
*/
@RestController
@RequestMapping("/dynamic/port")
public class DynamicPortController {
    @Resource
    private DynamicPortService dynamicPortService;

    @PostMapping("/add")
    public Result add(DynamicPort dynamicPort,@RequestParam(defaultValue = "requestId:0") String requestId) {
        dynamicPortService.save(dynamicPort);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        dynamicPortService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(DynamicPort dynamicPort,@RequestParam(defaultValue = "requestId:0") String requestId) {
        dynamicPortService.update(dynamicPort);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        DynamicPort dynamicPort = dynamicPortService.findById(id);
        return ResultGenerator.genSuccessResult(dynamicPort);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "requestId:0") String requestId) {
        PageHelper.startPage(page, size);
        List<DynamicPort> list = dynamicPortService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/updateDynamicPortBetweenId")
    public Result updateDynamicPortBetweenId(@RequestParam Integer id1, @RequestParam Integer id2,@RequestParam(defaultValue = "requestId:0") String requestId) {
        dynamicPortService.updateDynamicPortBetweenId(id1, id2);
        return ResultGenerator.genSuccessResult();

    }
}
