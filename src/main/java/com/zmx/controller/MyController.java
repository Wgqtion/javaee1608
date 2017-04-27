package com.zmx.controller;

import com.zmx.entity.Account;
import com.zmx.mapper.AccountMapper;
import com.zmx.util.MyBatisUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 处理器（控制器）
 *
 * @author 张明晓
 */
public class MyController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        SqlSession openSession = MyBatisUtil.getSqlSessionFactory().openSession();
        AccountMapper accountMapper = openSession.getMapper(AccountMapper.class);
        Account selectByPrimaryKey = accountMapper.selectByPrimaryKey(1);
        request.setAttribute("name", selectByPrimaryKey.getName());
        request.setAttribute("lave", "吴广庆");
        modelAndView.addObject("sexes", "女");
        modelAndView.setViewName("index");

        return modelAndView;
    }

}
