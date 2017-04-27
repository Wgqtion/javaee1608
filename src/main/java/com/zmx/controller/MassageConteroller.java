package com.zmx.controller;

import com.google.gson.Gson;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.zmx.entity.Account;
import com.zmx.entity.Comment;
import com.zmx.helper.BaseController;
import com.zmx.service.CommentService;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * 消息处理类。
 *
 * @author 张明晓
 */
@Controller
@RequestMapping("/toMessage")
public class MassageConteroller extends BaseController {

    @Resource
    CommentService commentService;

    @RequestMapping("/toCenter")
    public String toAccountCenter(Model model, HttpSession session) {
        Account user = (Account) session.getAttribute("selectAccount");
        model.addAttribute("account", user);
        return "center";
    }

    @RequestMapping("/addMessageComment")
    public void addComment(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        Account user = (Account) session.getAttribute("selectAccount");
        String addNewsId = (String) request.getParameter("addNewsId");
        String addCText = (String) request.getParameter("addCText");
        Comment comment = new Comment();
        comment.setAnId(user.getAnId());
        comment.setNewsId(Integer.parseInt(addNewsId));
        comment.setcText(addCText);
        comment.setSupport(0);
        comment.setTime(new Timestamp(System.currentTimeMillis()));
        int insert = 0;
        try {
            insert = commentService.insert(comment);
        } catch (Exception e) {
            //如果插入失败，判断用户是否已经评论过，评论过返回2，未评论返回0
            //DuplicateKeyException异常表示主键冲突
            insert = e instanceof DuplicateKeyException ? 2 : 0;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("judge", insert);
        super.flushResponse(response, new Gson().toJson(map));
    }

    @RequestMapping("/addImge")
    public void addImge(MultipartFile fileimg, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();
        byte[] imgByte = null;
        //后缀
        String suffix;
        if (fileimg != null) {
            //文件上传的文件的名称
            String filename = fileimg.getOriginalFilename();
            try {
                imgByte = fileimg.getBytes();
            } catch (IOException ex) {
                Logger.getLogger(MassageConteroller.class.getName()).log(Level.SEVERE, null, ex);
            }
            suffix = filename.substring(filename.lastIndexOf(".") + 1);
            map.put("fileimg", "data:image/" + suffix + ";base64," + Base64.getEncoder().encodeToString(imgByte));
        }

        super.flushResponse(response, new Gson().toJson(map));
    }
}
