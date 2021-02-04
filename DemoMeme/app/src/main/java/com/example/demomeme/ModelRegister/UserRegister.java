
package com.example.demomeme.ModelRegister;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRegister {

    @SerializedName("LIVETV")
    @Expose
    private List<ListRegister> lIVETV = null;

    public List<ListRegister> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListRegister> lIVETV) {
        this.lIVETV = lIVETV;
    }
}
