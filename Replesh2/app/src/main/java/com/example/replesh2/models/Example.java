
package com.example.replesh2.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

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
