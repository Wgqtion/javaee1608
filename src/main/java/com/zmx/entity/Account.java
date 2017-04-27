package com.zmx.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class Account implements Serializable {

    private static final long serialVersionUID = 10112312312L;

    private Integer anId;

    private String password;

    private String name;

    private String qq;

    private String tel;

    private Timestamp time;

    private String images;

    public Integer getAnId() {
        return anId;
    }

    public void setAnId(Integer anId) {
        this.anId = anId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * 个人信息修改判定。
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        Account accountObj = (Account) obj;
        if (null == this.name ? accountObj.getName() != null : !this.name.equals(accountObj.getName())) {
            return false;
        } else if (null == this.password ? false : !this.password.equals(accountObj.getPassword())) {
            return false;
        } else if (null == this.qq ? accountObj.getQq() != null : this.qq.equals(accountObj.getQq())) {
            return false;
        } else if (null == this.tel ? accountObj.getTel() != null : this.tel.equals(accountObj.getTel())) {
            return false;
        } else if (null == this.images ? accountObj.getImages() != null : this.images.equals(accountObj.getImages())) {
            return false;
        }
        return true;
    }

    /**
     * 获取头像图片Base64编码的字符串。
     *
     * @return the images
     */
    public String getImages() {
        return images;
    }

    /**
     * 修改头像图片Base64编码的字符串。
     *
     * @param images the images to set
     */
    public void setImages(String images) {
        this.images = images;
    }

}
