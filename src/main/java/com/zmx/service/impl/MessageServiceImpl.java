/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zmx.service.impl;

import com.zmx.entity.Message;
import com.zmx.mapper.MessageMapper;
import com.zmx.service.MessageService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 吴广庆
 */
@Transactional
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
    MessageMapper messageMapper;

    @Override
    public List<Message> selectMessage() {
        return messageMapper.selectMessage();
    }

}
