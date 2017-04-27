/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zmx.controller;

import com.zmx.entity.Account;
import com.zmx.entity.Message;
import com.zmx.entity.News;
import com.zmx.service.AccountService;
import com.zmx.service.MessageService;
import com.zmx.service.NewsService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.BASE64Encoder;

/**
 *
 * @author 吴广庆
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final BASE64Encoder encoder = new BASE64Encoder();
    @Resource //把AccountServiceImpl层注入到AccountService
    AccountService accountService;

    @Resource
    NewsService newsService;
    @Resource
    MessageService messageService;

    @RequestMapping("/userLogin")//子路径
    public String login(Account account, Model model, HttpSession session) {
        List<Message> messageList = messageService.selectMessage();
        Account selectAccount = accountService.selectAccount(account);
        session.setAttribute("selectAccount", selectAccount);
        session.setAttribute("messageList", messageList);
        return "admin_index";
    }
}
