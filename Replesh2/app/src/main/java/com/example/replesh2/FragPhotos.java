package com.example.replesh2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.replesh2.model.ChannelData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragPhotos extends Fragment {
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_photos,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_photos);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));


        final NetworkInterface networkInterface2 = MyApp.getRetrofit().create(NetworkInterface.class);

        Call<ChannelData> call = networkInterface2.listChannel();

        call.enqueue(new Callback<ChannelData>() {
            @Override
            public void onResponse(Call<ChannelData> call, Response<ChannelData> response) {
//                ChannelData data = response.body();
                PhotosAdapter photosAdapter = new PhotosAdapter(getContext(),response.body().getLIVETV());
                recyclerView.setAdapter(photosAdapter);
            }

            @Override
            public void onFailure(Call<ChannelData> call, Throwable t) {
                Log.e("sss",t.getMessage());
            }
        });



    }
}
