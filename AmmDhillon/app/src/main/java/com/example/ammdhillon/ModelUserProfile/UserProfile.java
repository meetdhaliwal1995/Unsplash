
package com.example.ammdhillon.ModelUserProfile;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class UserProfile {

    @SerializedName("LIVETV")
    @Expose
    private List<ListProfile> lIVETV = null;

    public List<ListProfile> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListProfile> lIVETV) {
        this.lIVETV = lIVETV;
    }


}
