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

import ModelApi.LatestModel.example.RegionInfo;

public class FragmetSingleRegion extends Fragment {

    TextView total, death, recover, name, country, info, update;
    RegionInfo regionInfo;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_single_region, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        total = view.findViewById(R.id.active_case);
        recover = view.findViewById(R.id.death_case);
        death = view.findViewById(R.id.recover_case);
        name = view.findViewById(R.id.total_caseu);
        info = view.findViewById(R.id.text_more);
        update = view.findViewById(R.id.update_text);


        total.setText(String.valueOf(regionInfo.getTotalCases()));
        death.setText(String.valueOf(regionInfo.getDeaths()));
        recover.setText(String.valueOf(regionInfo.getRecovered()));
        name.setText(regionInfo.getName());

        info.setOnClickListener(v -> {
            FragmentDate fragmentDate = new FragmentDate();
            fragmentDate.setRegionName(regionInfo.getName());
            getParentFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_in_left)
                    .add(R.id.container_layout, fragmentDate)
                    .addToBackStack("df")
                    .commit();
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentSingleUpdate fragmentSingleUpdate = new FragmentSingleUpdate();
                fragmentSingleUpdate.setRegionUpdate(regionInfo);
                getParentFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_right, R.anim.slide_in_left)
                        .add(R.id.container_layout, fragmentSingleUpdate)
                        .addToBackStack("ddd")
                        .commit();
            }
        });

    }

    public void setRegionInfo(RegionInfo regionInfo) {
        this.regionInfo = regionInfo;
    }
}
