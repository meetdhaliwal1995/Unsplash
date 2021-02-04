package com.example.myapplication;

import com.example.myapplication.model.category.CatData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkService {

    @GET("imp/api.php?get_category")
    Call<CatData> listCats();
}
