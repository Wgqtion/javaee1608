/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zmx.service;

import com.zmx.entity.Account;

/**
 *
 * @author 吴广庆
 */
public interface AccountService {

    Account selectAccount(Account record);

    public Account selectByPrimaryKey(Integer anId);

    public int updateByPrimaryKeySelective(Account account);
}
