package com.zmx.mapper;

import com.zmx.entity.Comment;
import java.util.List;

public interface CommentMapper {

    int deleteByPrimaryKey(Integer newsId);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByNewsId(Integer newsId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
}
