
package com.example.replesh2.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChannelData {

    @SerializedName("LIVETV")
    @Expose
    private List<LIVETV2> lIVETV = null;

    public List<LIVETV2> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<LIVETV2> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
