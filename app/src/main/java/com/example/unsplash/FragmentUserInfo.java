package com.example.unsplash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.unsplash.ModelApi.UserData.UserPhoto;
import com.example.unsplash.ModelApi.UserProfile.UserProfile;
import com.example.unsplash.presenters.ProfilePresenter;
import com.example.unsplash.presenters.UserPresenter;
import com.example.unsplash.views.ProfileContract;
import com.example.unsplash.views.UserContract;

import java.util.List;

public class FragmentUserInfo extends Fragment implements ProfileContract.profileView, UserContract.userView {
    TextView userBio, userName, userLocation, posts, followers, following, download;
    ImageView profileImage;
    String username;
    String page;
    ProfilePresenter profilePresenter;
    UserPresenter userPresenter;
    RecyclerView recyclerView;
    private AdapterUser adapterUser;
    boolean isScroolling = false;
    int currentItem, totalItem, scrollItem;
    GridLayoutManager gridLayoutManager;
    NestedScrollView nestedScrollView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userBio = view.findViewById(R.id.text_bio);
        userName = view.findViewById(R.id.text_name);
        userLocation = view.findViewById(R.id.text_location);
        profileImage = view.findViewById(R.id.profile_image);
        posts = view.findViewById(R.id.total_post);
        followers = view.findViewById(R.id.total_followers);
        following = view.findViewById(R.id.total_following);
        recyclerView = view.findViewById(R.id.recycler_id);
        nestedScrollView = view.findViewById(R.id.nested_scroll);
        page = "1";

//        adapterUser = new AdapterUser(getContext(), new ArrayList<UserPhoto>(), this);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
//        recyclerView.setAdapter(adapterUser);

        profilePresenter = new ProfilePresenter(this);
        profilePresenter.getData(username);

        userPresenter = new UserPresenter(this);
        userPresenter.getData(username, page);

        GridLayoutManager mLayoutManager;
        mLayoutManager = new GridLayoutManager(getActivity(), 3);


    }

    @Override
    public void setLatestData(final List<UserPhoto> userPhotos) {
//        adapterUser.set_list(userPhotos);
        adapterUser = new AdapterUser(getContext(), userPhotos, null);
        recyclerView.setAdapter(adapterUser);

//        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//
//                int visibleItemCount = linearLayoutManager.getChildCount();
//                int totalItemCount = linearLayoutManager.getItemCount();
//                int pastVisiblesItems = linearLayoutManager.findFirstVisibleItemPosition();
//
//                if (isScroolling) {
//                    if ((visibleItemCount + pastVisiblesItems) >= totalItemCount) {
//                        isScroolling = false;
//                        page = String.valueOf(Integer.parseInt(page) + 1);
//                        userPresenter.getData(username, page);
//
//                        isScroolling = true;
//                    }
//                }
//            }
//        });
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (!isScroolling) {
                    int visibleItemCount = gridLayoutManager.getChildCount();
                    int totalItemCount = gridLayoutManager.getItemCount();
                    int pastVisibleItems = gridLayoutManager.findFirstVisibleItemPosition();
                    if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                        //End of list

                        page = String.valueOf(Integer.parseInt(page) + 1);
                        userPresenter.getData(username, page);
                    }
                }
            }
        });

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setLatestData(UserProfile userProfile) {
        userBio.setText(userProfile.getBio());
        userLocation.setText(userProfile.getLocation());
        userName.setText(userProfile.getName());
        posts.setText(String.valueOf(userProfile.getTotalPhotos()));
        followers.setText(String.valueOf(userProfile.getFollowersCount()));
        following.setText(String.valueOf(userProfile.getFollowingCount()));
        Glide.with(getContext())
                .load(userProfile.getProfileImage().getLarge())
                .circleCrop()
                .into(profileImage);
    }

    public void setuserName(String username) {
        this.username = username;
    }

//    @Override
//    public void onClick() {
//
//    }

//    @Override
//    public void onPageBottom() {
//        userPresenter.getData(username, page);
//        page = String.valueOf(Integer.parseInt(page) + 1);
//    }


}
