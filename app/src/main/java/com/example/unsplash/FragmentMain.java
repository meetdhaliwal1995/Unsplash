package com.example.unsplash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unsplash.ModelApi.AllPhotos.AllPhoto;
import com.example.unsplash.presenters.PhotoPresenter;
import com.example.unsplash.views.PhotoContract;

import java.util.List;

public class FragmentMain extends Fragment implements PhotoContract.photoView, InterfaceContent {

    PhotoPresenter photoPresenter;
    RecyclerView recyclerView;
    ProgressBar progressBar;
    String page;
    boolean size;
    ImageView next, pre;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_);
        progressBar = view.findViewById(R.id.spin_kit);
        next = view.findViewById(R.id.text_next);
        pre = view.findViewById(R.id.text_pre);
        page = "1";
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        photoPresenter = new PhotoPresenter(this);
        photoPresenter.getData(page);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page = String.valueOf((Integer.parseInt(page) + 1));
                photoPresenter.getData(page);

            }

        });

        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page = String.valueOf(Integer.parseInt(page) - 1);
                photoPresenter.getData(page);
            }
        });


    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setLatestData(final List<AllPhoto> allPhoto) {
        AdapterPhotos adapterPhotos = new AdapterPhotos(getContext(), allPhoto, FragmentMain.this);
        recyclerView.setAdapter(adapterPhotos);
    }

    @Override
    public void callBack(AllPhoto allPhoto) {
        FragmentInfo fragmentInfo = new FragmentInfo();
        fragmentInfo.setInfo(allPhoto);
        getFragmentManager().beginTransaction()
                .add(R.id.container_layout, fragmentInfo)
                .addToBackStack("dd")
                .commit();

    }
}
