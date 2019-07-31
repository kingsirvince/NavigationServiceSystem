package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.DynamicPort;
import org.apache.ibatis.annotations.Param;

public interface DynamicPortMapper extends Mapper<DynamicPort> {
    Integer updateDynamicPortBetweenId(@Param("id1")Integer id1, @Param("id2")Integer id2);
}