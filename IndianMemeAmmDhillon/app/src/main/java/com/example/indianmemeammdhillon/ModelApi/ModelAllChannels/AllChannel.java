
package com.example.indianmemeammdhillon.ModelApi.ModelAllChannels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllChannel {

    @SerializedName("LIVETV")
    @Expose
    private List<AllChannelList> lIVETV = null;

    public List<AllChannelList> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<AllChannelList> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
