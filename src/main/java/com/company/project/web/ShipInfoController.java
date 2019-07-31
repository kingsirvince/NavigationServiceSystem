package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.ShipInfo;
import com.company.project.service.ShipInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2019/07/26.
*/
@RestController
@RequestMapping("/ship/info")
public class ShipInfoController {
    @Resource
    private ShipInfoService shipInfoService;

    @PostMapping("/add")
    public Result add(ShipInfo shipInfo) {
        shipInfoService.save(shipInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        shipInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ShipInfo shipInfo) {
        shipInfoService.update(shipInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        ShipInfo shipInfo = shipInfoService.findById(id);
        return ResultGenerator.genSuccessResult(shipInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<ShipInfo> list = shipInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/updateShipInfoBetweenId")
    public Result updateShipInfoBetweenId(@RequestParam Integer id1, @RequestParam Integer id2) {
        shipInfoService.updateShipInfoBetweenId(id1, id2);
        return ResultGenerator.genSuccessResult();

    }
}
