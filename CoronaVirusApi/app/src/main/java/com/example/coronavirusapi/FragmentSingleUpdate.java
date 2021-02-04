package com.example.coronavirusapi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.coronavirusapi.presenters.RegionPresenter;
import com.example.coronavirusapi.views.RegionContract;

import ModelApi.LatestModel.example.LatestCorona;
import ModelApi.LatestModel.example.RegionInfo;

public class FragmentSingleUpdate extends Fragment implements RegionContract.RegionView {

    TextView confirm, active, death, recover, back;
    RegionInfo regionInfo;
    RegionPresenter regionPresenter;
    ProgressBar progressBar;


    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_single_update, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        confirm = view.findViewById(R.id.total_caseS);
        active = view.findViewById(R.id.active_caseS);
        death = view.findViewById(R.id.death_caseS);
        recover = view.findViewById(R.id.recover_caseS);
        back = view.findViewById(R.id.back_text);
        progressBar = view.findViewById(R.id.spin_kit);
        regionPresenter = new RegionPresenter(this);
        regionPresenter.getData();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                getActivity().onBackPressed();
                getParentFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_in_left)
                        .remove(FragmentSingleUpdate.this)
                        .commit();
            }
        });


    }

    public void setRegionUpdate(RegionInfo regionInfo) {
        this.regionInfo = regionInfo;
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
    public void setLatestData(LatestCorona latestCorona) {

//        confirm.setText(latestCorona.getData().getRegions().get("usa").getChange().getTotalCases());
        confirm.setText(String.valueOf(regionInfo.getChange().getTotalCases()));
        active.setText(String.valueOf(regionInfo.getChange().getActiveCases()));
        death.setText(String.valueOf(regionInfo.getChange().getDeaths()));
        recover.setText(String.valueOf(regionInfo.getChange().getRecovered()));

    }
}
