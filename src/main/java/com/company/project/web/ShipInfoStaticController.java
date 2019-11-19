package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.ShipInfoStatic;
import com.company.project.service.ShipInfoStaticService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**非对外，内部模拟静态船舶使用
* Created by CodeGenerator on 2019/09/06.
*/
@RestController
@RequestMapping("/ship/info/static")
public class ShipInfoStaticController {
    @Resource
    private ShipInfoStaticService shipInfoStaticService;

    @PostMapping("/add")
    public Result add(ShipInfoStatic shipInfoStatic,@RequestParam(defaultValue = "requestId:0") String requestId) {
        shipInfoStaticService.save(shipInfoStatic);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        shipInfoStaticService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ShipInfoStatic shipInfoStatic,@RequestParam(defaultValue = "requestId:0") String requestId) {
        shipInfoStaticService.update(shipInfoStatic);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        ShipInfoStatic shipInfoStatic = shipInfoStaticService.findById(id);
        return ResultGenerator.genSuccessResult(shipInfoStatic);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "requestId:0") String requestId) {
        PageHelper.startPage(page, size);
        List<ShipInfoStatic> list = shipInfoStaticService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
