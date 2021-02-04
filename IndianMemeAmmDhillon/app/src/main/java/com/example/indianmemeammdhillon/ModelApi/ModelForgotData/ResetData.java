
package com.example.indianmemeammdhillon.ModelApi.ModelForgotData;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResetData {

    @SerializedName("LIVETV")
    @Expose
    private List<ListReset> lIVETV = null;

    public List<ListReset> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListReset> lIVETV) {
        this.lIVETV = lIVETV;
    }


}
