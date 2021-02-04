
package com.example.demomeme.SingleChannel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingelChannelList {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("cat_id")
    @Expose
    private String catId;
    @SerializedName("channel_type")
    @Expose
    private String channelType;
    @SerializedName("channel_title")
    @Expose
    private String channelTitle;
    @SerializedName("channel_url")
    @Expose
    private String channelUrl;
    @SerializedName("channel_type_ios")
    @Expose
    private String channelTypeIos;
    @SerializedName("channel_url_ios")
    @Expose
    private String channelUrlIos;
    @SerializedName("channel_thumbnail")
    @Expose
    private String channelThumbnail;
    @SerializedName("channel_desc")
    @Expose
    private String channelDesc;
    @SerializedName("total_views")
    @Expose
    private String totalViews;
    @SerializedName("total_rate")
    @Expose
    private String totalRate;
    @SerializedName("rate_avg")
    @Expose
    private String rateAvg;
    @SerializedName("category_name")
    @Expose
    private String categoryName;
    @SerializedName("related")
    @Expose
    private List<Related> related = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SingelChannelList withId(String id) {
        this.id = id;
        return this;
    }

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public SingelChannelList withCatId(String catId) {
        this.catId = catId;
        return this;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public SingelChannelList withChannelType(String channelType) {
        this.channelType = channelType;
        return this;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public SingelChannelList withChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
        return this;
    }

    public String getChannelUrl() {
        return channelUrl;
    }

    public void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
    }

    public SingelChannelList withChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
        return this;
    }

    public String getChannelTypeIos() {
        return channelTypeIos;
    }

    public void setChannelTypeIos(String channelTypeIos) {
        this.channelTypeIos = channelTypeIos;
    }

    public SingelChannelList withChannelTypeIos(String channelTypeIos) {
        this.channelTypeIos = channelTypeIos;
        return this;
    }

    public String getChannelUrlIos() {
        return channelUrlIos;
    }

    public void setChannelUrlIos(String channelUrlIos) {
        this.channelUrlIos = channelUrlIos;
    }

    public SingelChannelList withChannelUrlIos(String channelUrlIos) {
        this.channelUrlIos = channelUrlIos;
        return this;
    }

    public String getChannelThumbnail() {
        return channelThumbnail;
    }

    public void setChannelThumbnail(String channelThumbnail) {
        this.channelThumbnail = channelThumbnail;
    }

    public SingelChannelList withChannelThumbnail(String channelThumbnail) {
        this.channelThumbnail = channelThumbnail;
        return this;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }

    public SingelChannelList withChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
        return this;
    }

    public String getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(String totalViews) {
        this.totalViews = totalViews;
    }

    public SingelChannelList withTotalViews(String totalViews) {
        this.totalViews = totalViews;
        return this;
    }

    public String getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(String totalRate) {
        this.totalRate = totalRate;
    }

    public SingelChannelList withTotalRate(String totalRate) {
        this.totalRate = totalRate;
        return this;
    }

    public String getRateAvg() {
        return rateAvg;
    }

    public void setRateAvg(String rateAvg) {
        this.rateAvg = rateAvg;
    }

    public SingelChannelList withRateAvg(String rateAvg) {
        this.rateAvg = rateAvg;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public SingelChannelList withCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public List<Related> getRelated() {
        return related;
    }

    public void setRelated(List<Related> related) {
        this.related = related;
    }

    public SingelChannelList withRelated(List<Related> related) {
        this.related = related;
        return this;
    }


}
