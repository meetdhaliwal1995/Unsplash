
package com.example.ammdhillon.ModelClass;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryParent {

    @SerializedName("LIVETV")
    @Expose
    private List<CategoryItem> lIVETV = null;

    public List<CategoryItem> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<CategoryItem> lIVETV) {
        this.lIVETV = lIVETV;
    }

}
