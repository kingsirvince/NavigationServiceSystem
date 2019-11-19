//package com.company.project.web;
//import com.company.project.core.Result;
//import com.company.project.core.ResultGenerator;
//import com.company.project.model.Tablenotice;
//import com.company.project.service.TablenoticeService;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
//* Created by CodeGenerator on 2019/07/05.
//*/
//@RestController
//@RequestMapping("/tablenotice")
//public class TablenoticeController {
//    @Resource
//    private TablenoticeService tablenoticeService;
//
//    @PostMapping("/add")
//    public Result add(Tablenotice tablenotice) {
//        tablenoticeService.save(tablenotice);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/delete")
//    public Result delete(@RequestParam Integer id) {
//        tablenoticeService.deleteById(id);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/update")
//    public Result update(Tablenotice tablenotice) {
//        tablenoticeService.update(tablenotice);
//        return ResultGenerator.genSuccessResult();
//    }
//
//    @PostMapping("/detail")
//    public Result detail(@RequestParam Integer id) {
//        Tablenotice tablenotice = tablenoticeService.findById(id);
//        return ResultGenerator.genSuccessResult(tablenotice);
//    }
//
//    @PostMapping("/list")
//    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
//        PageHelper.startPage(page, size);
//        List<Tablenotice> list = tablenoticeService.findAll();
//        PageInfo pageInfo = new PageInfo(list);
//        return ResultGenerator.genSuccessResult(pageInfo);
//    }
//}
