
package com.example.ammdhillon.ModelUserLogin;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLogin {

    @SerializedName("LIVETV")
    @Expose
    private List<ListLogin> lIVETV = null;

    public List<ListLogin> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListLogin> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
