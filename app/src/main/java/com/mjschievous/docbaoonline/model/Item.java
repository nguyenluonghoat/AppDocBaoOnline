package com.mjschievous.docbaoonline.model;

import java.io.Serializable;

public class Item implements Serializable {

    public String title;
    public String description;
    public String detailUrl;
    public String thumbUrl;
    public String pubDate;

    public Item() {
    }

    public Item(String title, String description, String detailUrl, String thumbUrl, String pubDate) {
        this.title = title;
        this.description = description;
        this.detailUrl = detailUrl;
        this.thumbUrl = thumbUrl;
        this.pubDate = pubDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", detailUrl='" + detailUrl + '\'' +
                ", thumbUrl='" + thumbUrl + '\'' +
                ", pubDate='" + pubDate + '\'' +
                '}';
    }
}
