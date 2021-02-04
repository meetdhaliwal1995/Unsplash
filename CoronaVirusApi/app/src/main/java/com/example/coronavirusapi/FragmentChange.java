package com.example.coronavirusapi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.coronavirusapi.presenters.RegionPresenter;
import com.example.coronavirusapi.views.RegionContract;

import ModelApi.LatestModel.example.LatestCorona;

public class FragmentChange extends Fragment implements RegionContract.RegionView {

    ImageView more;
    TextView number, active, death, recovered, critical, tested, deathRatio, recoverdRatio;
    ProgressBar progressBar;
    RegionPresenter regionPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_update, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        number = view.findViewById(R.id.total_caseu);
        active = view.findViewById(R.id.case_active);
        death = view.findViewById(R.id.case_death);
        recovered = view.findViewById(R.id.case_recoverd);
        critical = view.findViewById(R.id.case_critical);
        tested = view.findViewById(R.id.case_tested);
        deathRatio = view.findViewById(R.id.case_death_ratio);
        recoverdRatio = view.findViewById(R.id.case_recovery_ratio);
        progressBar = view.findViewById(R.id.spin_kit);
        regionPresenter = new RegionPresenter(this);
        regionPresenter.getData();
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

        number.setText(String.valueOf(latestCorona.getData().getChange().getTotalCases()));
        active.setText(String.valueOf(latestCorona.getData().getChange().getActiveCases()));
        death.setText(String.valueOf(latestCorona.getData().getChange().getDeaths()));
        recovered.setText(String.valueOf(latestCorona.getData().getChange().getRecovered()));
        critical.setText(String.valueOf(latestCorona.getData().getChange().getCritical()));
        tested.setText(String.valueOf(latestCorona.getData().getChange().getTested()));
        deathRatio.setText(String.valueOf(latestCorona.getData().getChange().getDeathRatio()).substring(0, 8));
        recoverdRatio.setText(String.valueOf(latestCorona.getData().getChange().getRecoveryRatio()).substring(0, 5));

    }
}
