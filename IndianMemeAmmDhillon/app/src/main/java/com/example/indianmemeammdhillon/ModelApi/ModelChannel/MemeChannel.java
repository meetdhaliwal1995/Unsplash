
package com.example.indianmemeammdhillon.ModelApi.ModelChannel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemeChannel {

    @SerializedName("LIVETV")
    @Expose
    private List<ListChannel> lIVETV = null;

    public List<ListChannel> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListChannel> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
