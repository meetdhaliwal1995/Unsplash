
package com.example.ammdhillon.ModelResetPassword;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotPassword {

    @SerializedName("LIVETV")
    @Expose
    private List<ListResetPass> lIVETV = null;

    public List<ListResetPass> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListResetPass> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
