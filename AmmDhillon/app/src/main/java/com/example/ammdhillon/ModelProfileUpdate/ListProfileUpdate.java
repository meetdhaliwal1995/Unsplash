
package com.example.ammdhillon.ModelProfileUpdate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ListProfileUpdate {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("success")
    @Expose
    private String success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }


}
