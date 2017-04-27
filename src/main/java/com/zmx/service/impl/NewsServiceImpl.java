/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zmx.service.impl;

import com.zmx.entity.News;
import com.zmx.mapper.NewsMapper;
import com.zmx.service.NewsService;
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
public class NewsServiceImpl implements NewsService {

    @Resource
    NewsMapper newsMapper;

    @Override
    public int insert(News record) {
        return newsMapper.insert(record);
    }

    @Override
    public List<News> newsList() {
        return newsMapper.newsList();
    }

}
