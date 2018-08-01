package com.sobt.pro.dao.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TArticle {
    private Integer tid;

    private String artType;

    private String title;

    private String memo;

    private String sourceUrl;

    private String smallPic;

    private String source;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date pubDate;

    private Integer status;

    private String dirKey;

    private String pDirKey;

    private String dirName;

    private String content;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getArtType() {
        return artType;
    }

    public void setArtType(String artType) {
        this.artType = artType == null ? null : artType.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl == null ? null : sourceUrl.trim();
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic == null ? null : smallPic.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDirKey() {
        return dirKey;
    }

    public void setDirKey(String dirKey) {
        this.dirKey = dirKey == null ? null : dirKey.trim();
    }

    public String getpDirKey() {
        return pDirKey;
    }

    public void setpDirKey(String pDirKey) {
        this.pDirKey = pDirKey == null ? null : pDirKey.trim();
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName == null ? null : dirName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}