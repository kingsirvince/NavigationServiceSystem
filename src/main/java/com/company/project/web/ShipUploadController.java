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

    /**
     * 上传状态截取监控
     * @param shipUpload
     * @return
     */

//    int i=0;@RequestParam(defaultValue="0") String requestId
    @PostMapping("/update")
    public Result update(ShipUpload shipUpload) {
        shipUploadService.update(shipUpload);


//        //得到想要监控的几个参数
//        String shipMmsi=shipUpload.getShipMmsi().toString();
//
//        //延迟2次，执行后续，防止快速刷屏
//            if (i > 2) {
//
//                String shipState = shipUpload.getShipState();
//                String shipLongitude = shipUpload.getShipLongitude().toString();
//                String shipLatitude = shipUpload.getShipLatitude().toString();
//                //合并
//                String monitorLog = "船舶上传： MMSI= " + shipMmsi + " ,在航状态= " + shipState + " ,经度= " + shipLongitude + " ,维度= " + shipLatitude + " ; ";
//                System.out.println("****************  " + monitorLog + "   ****************  ");
//                //写入到ship_monitor表中
//                ShipMonitor shipMonitor = new ShipMonitor();
//                shipMonitor.setMonitorlog(monitorLog);
//                shipMonitor.setType("shipUpload");
//
//
//                shipMonitorService.save(shipMonitor);
//
//                i = 0;
//            } else {
//                i++;
//            }

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
