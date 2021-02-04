
package com.example.indianmemeammdhillon.ModelApi.ModelCategory;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemeCategory {

    @SerializedName("LIVETV")
    @Expose
    private List<ListCategory> lIVETV = null;

    public List<ListCategory> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListCategory> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
