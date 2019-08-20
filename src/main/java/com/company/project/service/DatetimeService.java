package com.company.project.service;

import com.company.project.dao.DatetimeMapper;
import com.company.project.model.Datetime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatetimeService {
    @Autowired
    DatetimeMapper datetimeMapper;
   public List<Datetime> getAll(){
        return datetimeMapper.getAll();
    }
}
