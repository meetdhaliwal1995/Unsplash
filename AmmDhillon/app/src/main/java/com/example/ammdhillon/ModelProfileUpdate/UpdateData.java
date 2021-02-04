
package com.example.ammdhillon.ModelProfileUpdate;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateData {

    @SerializedName("LIVETV")
    @Expose
    private List<ListProfileUpdate> lIVETV = null;

    public List<ListProfileUpdate> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListProfileUpdate> lIVETV) {
        this.lIVETV = lIVETV;
    }


}
