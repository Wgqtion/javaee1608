package com.zmx.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {

    private static final long serialVersionUID = 936823L;

    private Integer newsId;

    private Integer anId;

    private Integer support;

    private Timestamp time;

    private String cText;

    private String cname;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getAnId() {
        return anId;
    }

    public void setAnId(Integer anId) {
        this.anId = anId;
    }

    public Integer getSupport() {
        return support;
    }

    public void setSupport(Integer support) {
        this.support = support;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getcText() {
        return cText;
    }

    public void setcText(String cText) {
        this.cText = cText == null ? null : cText.trim();
    }

    /**
     * @return the cname
     */
    public String getCname() {
        return cname;
    }

    /**
     * @param cname the cname to set
     */
    public void setCname(String cname) {
        this.cname = cname;
    }
}
