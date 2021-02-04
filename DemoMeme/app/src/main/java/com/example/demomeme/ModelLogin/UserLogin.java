
package com.example.demomeme.ModelLogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

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
