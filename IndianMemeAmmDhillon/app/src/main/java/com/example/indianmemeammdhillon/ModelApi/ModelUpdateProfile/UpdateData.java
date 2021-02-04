
package com.example.indianmemeammdhillon.ModelApi.ModelUpdateProfile;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdateData {

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
