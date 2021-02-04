
package com.example.indianmemeammdhillon.ModelApi.ModelSingleChannel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SingleChannel {

    @SerializedName("LIVETV")
    @Expose
    private List<ListSingleChannel> lIVETV = null;

    public List<ListSingleChannel> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListSingleChannel> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
