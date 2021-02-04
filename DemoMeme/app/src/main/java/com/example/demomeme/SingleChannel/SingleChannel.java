
package com.example.demomeme.SingleChannel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleChannel {

    @SerializedName("LIVETV")
    @Expose
    private List<SingelChannelList> lIVETV = null;

    public List<SingelChannelList> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<SingelChannelList> lIVETV) {
        this.lIVETV = lIVETV;
    }

    public SingleChannel withLIVETV(List<SingelChannelList> lIVETV) {
        this.lIVETV = lIVETV;
        return this;
    }



}
