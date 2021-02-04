
package com.example.ammdhillon.AllVideos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LIVETV {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("video_type")
    @Expose
    private String videoType;
    @SerializedName("video_title")
    @Expose
    private String videoTitle;
    @SerializedName("video_url")
    @Expose
    private String videoUrl;
    @SerializedName("video_id")
    @Expose
    private String videoId;
    @SerializedName("video_thumbnail_b")
    @Expose
    private String videoThumbnailB;
    @SerializedName("video_thumbnail_s")
    @Expose
    private String videoThumbnailS;
    @SerializedName("total_views")
    @Expose
    private String totalViews;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoThumbnailB() {
        return videoThumbnailB;
    }

    public void setVideoThumbnailB(String videoThumbnailB) {
        this.videoThumbnailB = videoThumbnailB;
    }

    public String getVideoThumbnailS() {
        return videoThumbnailS;
    }

    public void setVideoThumbnailS(String videoThumbnailS) {
        this.videoThumbnailS = videoThumbnailS;
    }

    public String getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(String totalViews) {
        this.totalViews = totalViews;
    }

}
