
package com.example.replesh2.Video;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoData {

    @SerializedName("LIVETV")
    @Expose
    private List<LIVETV3> lIVETV = null;

    public List<LIVETV3> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<LIVETV3> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
