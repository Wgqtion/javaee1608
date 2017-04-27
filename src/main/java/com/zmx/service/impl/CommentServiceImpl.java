/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zmx.service.impl;

import com.zmx.entity.Comment;
import com.zmx.mapper.CommentMapper;
import com.zmx.service.CommentService;
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
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentMapper commentMapper;

    @Override
    public List<Comment> selectByNewsId(Integer newsId) {
        return commentMapper.selectByNewsId(newsId);
    }

}
