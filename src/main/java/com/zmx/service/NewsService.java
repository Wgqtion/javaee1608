/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zmx.service;

import com.zmx.entity.News;
import java.util.List;

/**
 *
 * @author 吴广庆
 */
public interface NewsService {

    int insert(News record);

    List<News> newsList();
}
