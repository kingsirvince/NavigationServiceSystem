package com.company.project.web;

import com.company.project.model.Datetime;
import com.company.project.service.DatetimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/datetime")
public class DatetimeController {

    @Autowired
    DatetimeService datetimeService;
    @PostMapping("/list")
    public List<Datetime> list(){
        return datetimeService.getAll();

    }

}
