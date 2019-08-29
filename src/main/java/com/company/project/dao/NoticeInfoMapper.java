package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.NoticeInfo;

import java.util.List;

public interface NoticeInfoMapper extends Mapper<NoticeInfo> {
    List<NoticeInfo> getLatest();
}