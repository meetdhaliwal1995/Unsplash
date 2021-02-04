
package com.example.ammdhillon.ModelAppDetail;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AppDetail {

    @SerializedName("LIVETV")
    @Expose
    private List<LIVETV> lIVETV = null;

    public List<LIVETV> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<LIVETV> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
