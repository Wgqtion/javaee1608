package com.zmx.mapper;

import com.zmx.entity.Statistics;
import com.zmx.entity.StatisticsKey;

public interface StatisticsMapper {
    int deleteByPrimaryKey(StatisticsKey key);

    int insert(Statistics record);

    int insertSelective(Statistics record);

    Statistics selectByPrimaryKey(StatisticsKey key);

    int updateByPrimaryKeySelective(Statistics record);

    int updateByPrimaryKey(Statistics record);
}