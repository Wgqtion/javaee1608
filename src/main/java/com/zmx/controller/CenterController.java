/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zmx.controller;

import com.zmx.entity.Account;
import com.zmx.service.AccountService;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

/**
 *
 * @author 吴广庆
 */
@Controller
@RequestMapping("/account")
public class CenterController {

    private static BASE64Encoder encoder = new BASE64Encoder();

    @Resource
    AccountService accountService;

    @RequestMapping("/accountChenge")
    public String accountChange(
            @RequestParam(value = "imageInput", required = false) MultipartFile imageInput,
            Account account,
            Model model,
            HttpSession session,
            HttpServletRequest requests) {
        Account user = (Account) session.getAttribute("selectAccount");
        //文件上传的文件的名称
        String filename = imageInput.getOriginalFilename();
        String path = session.getServletContext().getRealPath("/accountChenge");

        File dir = new File(path);
        //后缀
        String suffix = filename.substring(filename.lastIndexOf(".") + 1);
        if (account != null && !account.equals(user)) {
            account.setAnId(user.getAnId());
            if (account.getPassword() == null) {
                account.setPassword(user.getPassword());
            }
            if (imageInput != null) {
                try {
                    byte[] imgByte = imageInput.getBytes();
                    account.setImages("data:image/" + suffix + ";base64," + encoder.encode(imgByte));
                } catch (IOException ex) {
                    Logger.getLogger(CenterController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            account.setTime(new Timestamp(System.currentTimeMillis()));
            int count = accountService.updateByPrimaryKeySelective(account);
            model.addAttribute("accountSuccess", count);
            if (count != 0) {
                session.setAttribute("selectAccount", account);
            }
        } else {
            return "center";
        }
        return "admin_index";
    }

    @RequestMapping("/passwordChange")
    public String passwordChange() {

        return "center";
    }
}
