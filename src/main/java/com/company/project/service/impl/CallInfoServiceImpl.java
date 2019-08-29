package com.company.project.service.impl;

import com.company.project.dao.CallInfoMapper;
import com.company.project.model.CallInfo;
import com.company.project.service.CallInfoService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
@Service
@Transactional
public class CallInfoServiceImpl extends AbstractService<CallInfo> implements CallInfoService {
    @Resource
    private CallInfoMapper callInfoMapper;

    @Override
    public List<CallInfo> getLatest() {
        return callInfoMapper.getLatest();
    }
}
