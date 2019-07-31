package com.company.project.service;
import com.company.project.model.DynamicPort;
import com.company.project.core.Service;


/**
 * Created by CodeGenerator on 2019/07/31.
 */
public interface DynamicPortService extends Service<DynamicPort> {
    Integer updateDynamicPortBetweenId(Integer id1,Integer id2);
}
