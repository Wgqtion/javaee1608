/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zmx.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author 吴广庆
 */
public class Message implements Serializable {

    private static final long serialVersionUID = 8936296L;

    private Integer newsId;

    private String titleName;

    private Integer anId;

    private Integer top;

    private Integer tread;

    private Timestamp time;

    private String bodyText;

    private String images;

    private String imagesString;

    private String nname;

    private List<Comment> comments;

    public String getBodyText() {
        return bodyText;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText == null ? null : bodyText.trim();
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    public Integer getAnId() {
        return anId;
    }

    public void setAnId(Integer anId) {
        this.anId = anId;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getTread() {
        return tread;
    }

    public void setTread(Integer tread) {
        this.tread = tread;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * @return the imagesString
     */
    public String getImagesString() {
        return imagesString;
    }

    /**
     * @param imagesString the imagesString to set
     */
    public void setImagesString(String imagesString) {
        this.imagesString = imagesString;
    }

    /**
     * @return the nname
     */
    public String getNname() {
        return nname;
    }

    /**
     * @param nname the nname to set
     */
    public void setNname(String nname) {
        this.nname = nname;
    }

    public List<Comment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}
