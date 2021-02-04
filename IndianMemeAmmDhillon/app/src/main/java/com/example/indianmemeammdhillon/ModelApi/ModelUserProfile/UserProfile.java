
package com.example.indianmemeammdhillon.ModelApi.ModelUserProfile;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfile {

    @SerializedName("LIVETV")
    @Expose
    private List<ListUserProfile> lIVETV = null;

    public List<ListUserProfile> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListUserProfile> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
