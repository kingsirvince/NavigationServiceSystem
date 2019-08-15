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
    public Result delete(@RequestParam Integer shipMmsi) {
        Integer id = shipMmsi;
        shipUploadService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ShipUpload shipUpload) {
        shipUploadService.update(shipUpload);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer shipMmsi) {
        Integer id = shipMmsi;
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

}
