
package com.example.demomeme.ModelCategory;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryMeme {

    @SerializedName("LIVETV")
    @Expose
    private List<ListCat> lIVETV = null;

    public List<ListCat> getLIVETV() {
        return lIVETV;
    }

    public void setLIVETV(List<ListCat> lIVETV) {
        this.lIVETV = lIVETV;
    }



}
