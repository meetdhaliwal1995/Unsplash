
package com.example.demomeme.SingleChannel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Related {

    @SerializedName("rel_id")
    @Expose
    private String relId;
    @SerializedName("rel_channel_title")
    @Expose
    private String relChannelTitle;
    @SerializedName("rel_channel_url")
    @Expose
    private String relChannelUrl;
    @SerializedName("rel_channel_url_ios")
    @Expose
    private String relChannelUrlIos;
    @SerializedName("rel_channel_thumbnail")
    @Expose
    private String relChannelThumbnail;

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId;
    }

    public Related withRelId(String relId) {
        this.relId = relId;
        return this;
    }

    public String getRelChannelTitle() {
        return relChannelTitle;
    }

    public void setRelChannelTitle(String relChannelTitle) {
        this.relChannelTitle = relChannelTitle;
    }

    public Related withRelChannelTitle(String relChannelTitle) {
        this.relChannelTitle = relChannelTitle;
        return this;
    }

    public String getRelChannelUrl() {
        return relChannelUrl;
    }

    public void setRelChannelUrl(String relChannelUrl) {
        this.relChannelUrl = relChannelUrl;
    }

    public Related withRelChannelUrl(String relChannelUrl) {
        this.relChannelUrl = relChannelUrl;
        return this;
    }

    public String getRelChannelUrlIos() {
        return relChannelUrlIos;
    }

    public void setRelChannelUrlIos(String relChannelUrlIos) {
        this.relChannelUrlIos = relChannelUrlIos;
    }

    public Related withRelChannelUrlIos(String relChannelUrlIos) {
        this.relChannelUrlIos = relChannelUrlIos;
        return this;
    }

    public String getRelChannelThumbnail() {
        return relChannelThumbnail;
    }

    public void setRelChannelThumbnail(String relChannelThumbnail) {
        this.relChannelThumbnail = relChannelThumbnail;
    }

    public Related withRelChannelThumbnail(String relChannelThumbnail) {
        this.relChannelThumbnail = relChannelThumbnail;
        return this;
    }



}
