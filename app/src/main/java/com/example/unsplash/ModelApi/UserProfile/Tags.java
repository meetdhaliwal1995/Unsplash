
package com.example.unsplash.ModelApi.UserProfile;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tags {

    @SerializedName("custom")
    @Expose
    private List<Custom> custom = null;
    @SerializedName("aggregated")
    @Expose
    private List<Object> aggregated = null;

    public List<Custom> getCustom() {
        return custom;
    }

    public void setCustom(List<Custom> custom) {
        this.custom = custom;
    }

    public List<Object> getAggregated() {
        return aggregated;
    }

    public void setAggregated(List<Object> aggregated) {
        this.aggregated = aggregated;
    }

}
