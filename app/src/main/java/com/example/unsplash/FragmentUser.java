package com.example.unsplash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unsplash.ModelApi.UserData.UserPhoto;
import com.example.unsplash.presenters.UserPresenter;
import com.example.unsplash.views.UserContract;

import java.util.List;

public class FragmentUser extends Fragment implements UserContract.userView {
    RecyclerView recyclerView;
    UserPresenter userPresenter;
    String name, page, size;
    ProgressBar progressBar;
    ImageView next, pre;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycler_);
        progressBar = view.findViewById(R.id.spin_kit);
        next = view.findViewById(R.id.text_next);
        page = "1";
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        userPresenter = new UserPresenter(this);
        userPresenter.getData(name, page);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page = String.valueOf(Integer.parseInt(page) + 1);
                userPresenter.getData(name, page);
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
    public void setLatestData(List<UserPhoto> userPhotos) {

        if (userPhotos.size() == 0) {
            Toast.makeText(getContext(), "Picture not found", Toast.LENGTH_SHORT).show();
            return;
        }

        AdapterUser adapterUser = new AdapterUser(getContext(), userPhotos, null);

        recyclerView.setAdapter(adapterUser);

    }


    public void setDetail(String name) {
        this.name = name;
    }
}
