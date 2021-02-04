package com.example.replesh2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.replesh2.Video.VideoData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragCollections extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_collection1,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_collection);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Log.e("sss","fff");

        final NetworkInterface networkInterface = MyApp.getRetrofit().create(NetworkInterface.class);

        Call<VideoData> call = networkInterface.listCats();

        call.enqueue(new Callback<VideoData>() {
            @Override
            public void onResponse(Call<VideoData> call, Response<VideoData> response) {
                Log.e("ddd","fff");
                CollectionAdapter adapter = new CollectionAdapter(getContext(),response.body().getLIVETV());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<VideoData> call, Throwable t) {
                Log.e("sss",t.getMessage());
            }
        });

    }
}
