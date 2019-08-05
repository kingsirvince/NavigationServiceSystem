package com.company.project.web;

import com.company.project.service.ReadExcelService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/Excel")
public class ReadExcelController {

    @Resource
    ReadExcelService readExcelService;

    @PostMapping("/file")
    public String add(@RequestParam("file")MultipartFile file) {

        Map<Integer, Map<Integer, Object>> map = readExcelService.addCustomerInfo(file);

        ReadExcelService.keySet(map);

        return "read excel success";
    }
    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestParam("proxyfile") MultipartFile file) {
        System.err.println(file.getName());
        return "success";
    }


}

