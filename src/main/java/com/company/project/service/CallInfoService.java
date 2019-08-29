package com.company.project.service;
import com.company.project.model.CallInfo;
import com.company.project.core.Service;

import java.util.List;


/**
 * Created by CodeGenerator on 2019/08/12.
 */
public interface CallInfoService extends Service<CallInfo> {
    List<CallInfo> getLatest();

}
