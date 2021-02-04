
package com.example.ammdhillon.ModelSingle;

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

    public String getRelChannelTitle() {
        return relChannelTitle;
    }

    public void setRelChannelTitle(String relChannelTitle) {
        this.relChannelTitle = relChannelTitle;
    }

    public String getRelChannelUrl() {
        return relChannelUrl;
    }

    public void setRelChannelUrl(String relChannelUrl) {
        this.relChannelUrl = relChannelUrl;
    }

    public String getRelChannelUrlIos() {
        return relChannelUrlIos;
    }

    public void setRelChannelUrlIos(String relChannelUrlIos) {
        this.relChannelUrlIos = relChannelUrlIos;
    }

    public String getRelChannelThumbnail() {
        return relChannelThumbnail;
    }

    public void setRelChannelThumbnail(String relChannelThumbnail) {
        this.relChannelThumbnail = relChannelThumbnail;
    }

}
