package com.zmx.mapper;

import com.zmx.entity.Account;

public interface AccountMapper {

    int deleteByPrimaryKey(Integer anId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectAccount(Account record);

    Account selectByPrimaryKey(Integer anId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}
