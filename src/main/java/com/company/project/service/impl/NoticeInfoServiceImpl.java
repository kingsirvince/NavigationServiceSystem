package com.company.project.service.impl;

import com.company.project.dao.NoticeInfoMapper;
import com.company.project.model.NoticeInfo;
import com.company.project.service.NoticeInfoService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
@Service
@Transactional
public class NoticeInfoServiceImpl extends AbstractService<NoticeInfo> implements NoticeInfoService {
    @Resource
    private NoticeInfoMapper noticeInfoMapper;

}
