package com.company.project.service;

import com.company.project.core.Service;
import com.company.project.model.NoticeInfo;

import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
public interface NoticeInfoService extends Service<NoticeInfo> {
    List<NoticeInfo> getLatest();
}
