/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zmx.service;

import com.zmx.entity.Comment;
import java.util.List;

/**
 *
 * @author 吴广庆
 */
public interface CommentService {

    List<Comment> selectByNewsId(Comment record);

    int insert(Comment record);
}
