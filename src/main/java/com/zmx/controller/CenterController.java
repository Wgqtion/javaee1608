package com.zmx.controller;

import com.zmx.entity.Account;
import com.zmx.service.AccountService;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author 张明晓
 */
@Controller
@RequestMapping("/account")
public class CenterController {

    // Account 表查询/更新的service
    @Resource
    AccountService accountService;

    /**
     * 地址栏输入http://localhost:8080/SunUnityMaven/adopt/account/accountChenge跳转的方法
     *
     * @param imageInput 接受上传的图片
     * @param account 接受修改的字段
     * @param model 传值给下个画面
     * @param session session做登录信息更新
     * @return 返回要跳转的画面
     */
    @RequestMapping("/accountChenge")
    public String accountChange(
            @RequestParam(value = "imageInput", required = false) MultipartFile imageInput,
            Account account,
            Model model,
            HttpSession session) {
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
                    account.setImages("data:image/" + suffix + ";base64," + Base64.getEncoder().encodeToString(imgByte));
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
