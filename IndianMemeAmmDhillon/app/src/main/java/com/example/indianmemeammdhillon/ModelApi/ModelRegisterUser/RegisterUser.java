
package com.example.indianmemeammdhillon.ModelApi.ModelRegisterUser;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterUser {

    @SerializedName("LIVETV")
    @Expose
    private List<ListRegisterUser> lIVETV = null;

    public List<ListRegisterUser> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListRegisterUser> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
