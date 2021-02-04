
package com.example.indianmemeammdhillon.ModelApi.ModelSingleChannel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListSingleChannel {

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

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getChannelUrl() {
        return channelUrl;
    }

    public void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl;
    }

    public String getChannelTypeIos() {
        return channelTypeIos;
    }

    public void setChannelTypeIos(String channelTypeIos) {
        this.channelTypeIos = channelTypeIos;
    }

    public String getChannelUrlIos() {
        return channelUrlIos;
    }

    public void setChannelUrlIos(String channelUrlIos) {
        this.channelUrlIos = channelUrlIos;
    }

    public String getChannelThumbnail() {
        return channelThumbnail;
    }

    public void setChannelThumbnail(String channelThumbnail) {
        this.channelThumbnail = channelThumbnail;
    }

    public String getChannelDesc() {
        return channelDesc;
    }

    public void setChannelDesc(String channelDesc) {
        this.channelDesc = channelDesc;
    }

    public String getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(String totalViews) {
        this.totalViews = totalViews;
    }

    public String getTotalRate() {
        return totalRate;
    }

    public void setTotalRate(String totalRate) {
        this.totalRate = totalRate;
    }

    public String getRateAvg() {
        return rateAvg;
    }

    public void setRateAvg(String rateAvg) {
        this.rateAvg = rateAvg;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Related> getRelated() {
        return related;
    }

    public void setRelated(List<Related> related) {
        this.related = related;
    }

}
