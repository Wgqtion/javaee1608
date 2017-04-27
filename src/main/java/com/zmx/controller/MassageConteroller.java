/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zmx.controller;

import com.zmx.entity.Account;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 吴广庆
 */
@Controller
@RequestMapping("/toMessage")
public class MassageConteroller {

    @RequestMapping("/toCenter")
    public String toAccountCenter(Model model, HttpSession session) {
        Account user = (Account) session.getAttribute("selectAccount");
        model.addAttribute("account", user);
        return "center";
    }

}
