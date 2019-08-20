package com.company.project.service.impl;

import com.company.project.dao.CallUploadMapper;
import com.company.project.model.CallUpload;
import com.company.project.service.CallUploadService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2019/08/15.
 */
@Service
@Transactional
public class CallUploadServiceImpl extends AbstractService<CallUpload> implements CallUploadService {
    @Resource
    private CallUploadMapper callUploadMapper;

}
