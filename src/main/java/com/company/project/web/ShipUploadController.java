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
//    private ShipMonitorService shipMonitorService; 这样不行
/*    //得用载入来调用service的方法
    @Autowired
    private ShipMonitorService shipMonitorService;*/

    @PostMapping("/add")
    public Result add(ShipUpload shipUpload,@RequestParam(defaultValue = "requestId:0") String requestId) {
        shipUploadService.save(shipUpload);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer shipMmsi,@RequestParam(defaultValue = "requestId:0") String requestId) {
        Integer id = shipMmsi;
        shipUploadService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    /**
     * 更新上传船舶，其中监控通过提取实体类中的shipMmsi获取,无需上传requestId
     * @param shipUpload
     * @return
     */


    @PostMapping("/update")
    public Result update(ShipUpload shipUpload) {
        shipUploadService.update(shipUpload);

        return ResultGenerator.genSuccessResult();
    }




    @PostMapping("/detail")
    public Result detail(@RequestParam Integer shipMmsi,@RequestParam(defaultValue = "requestId:0") String requestId) {
        Integer id = shipMmsi;
        ShipUpload shipUpload = shipUploadService.findById(id);
        return ResultGenerator.genSuccessResult(shipUpload);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "requestId:0") String requestId) {
        PageHelper.startPage(page, size);
        List<ShipUpload> list = shipUploadService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @PostMapping("/getChannelDivisionID")
    public Result getChannelDivisionID(@RequestParam Integer MMSI,@RequestParam(defaultValue = "requestId:0") String requestId) {
        String channelDivisionID = shipUploadService.getChannelDivisionID(MMSI);
        return ResultGenerator.genSuccessResult(channelDivisionID);
    }

}
