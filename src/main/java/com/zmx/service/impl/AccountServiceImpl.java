/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zmx.service.impl;

import com.zmx.entity.Account;
import com.zmx.mapper.AccountMapper;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.zmx.service.AccountService;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 吴广庆
 */
@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountMapper accountMapper;

    @Override
    public int updateByPrimaryKeySelective(Account account) {
        return accountMapper.updateByPrimaryKeySelective(account);
    }

    @Override
    public Account selectByPrimaryKey(Integer anId) {
        return accountMapper.selectByPrimaryKey(anId);
    }

    @Override
    public Account selectAccount(Account record) {
        return accountMapper.selectAccount(record);
    }

}
