package com.zmx.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 消息评论。
 *
 * @author 张明晓
 */
public class Comment implements Serializable {

    private static final long serialVersionUID = 936823L;

    private Integer newsId;

    private Integer anId;

    private Integer support;

    private Timestamp time;

    private String cText;

    private String cname;

    /**
     * 消息ID。
     *
     * @return newsId
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * 设置评论第几条。
     *
     * @param newsId
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * 获取评论人ID。
     *
     * @return anId
     */
    public Integer getAnId() {
        return anId;
    }

    /**
     * 设置品论人ID。
     *
     * @param anId
     */
    public void setAnId(Integer anId) {
        this.anId = anId;
    }

    /**
     * 获取支持数。
     *
     * @return support
     */
    public Integer getSupport() {
        return support;
    }

    /**
     * 设置支持数。
     *
     * @param support
     */
    public void setSupport(Integer support) {
        this.support = support;
    }

    /**
     * 获取评论时间。
     *
     * @return time
     */
    public Timestamp getTime() {
        return time;
    }

    /**
     * 设置评论时间。
     *
     * @param time
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * 获取评语。
     *
     * @return cText
     */
    public String getcText() {
        return cText;
    }

    /**
     * 设置评语。
     *
     * @param cText
     */
    public void setcText(String cText) {
        this.cText = cText == null ? null : cText.trim();
    }

    /**
     * 消息评论人姓名。
     *
     * @return the cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * 设置评论人姓名。（用不到，主要是在接受消息的时候根据品论人ID获取评论人姓名）
     *
     * @param cname the cname to set
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
}
