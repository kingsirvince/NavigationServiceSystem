package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.CallInfo;

import java.util.List;

public interface CallInfoMapper extends Mapper<CallInfo> {
    List<CallInfo> getLatest();


}