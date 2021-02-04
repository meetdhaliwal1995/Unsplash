
package com.example.indianmemeammdhillon.ModelApi.ModelAppDetail;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppDetail {

    @SerializedName("LIVETV")
    @Expose
    private List<ListAppDetail> lIVETV = null;

    public List<ListAppDetail> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListAppDetail> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
