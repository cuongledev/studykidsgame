package com.cuongle.studykidsgame.ui.start;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cuongle.studykidsgame.R;
import com.cuongle.studykidsgame.ui.home.HomeFragment;
import com.cuongle.studykidsgame.ui.play.PlayFragment;
import com.cuongle.studykidsgame.ui.subjects.SubjectsFragment;

import static maes.tech.intentanim.CustomIntent.customType;

public class StartFragment extends Fragment implements View.OnClickListener {

    private ImageView btnPlay,btnQuit;

    private StartViewModel mViewModel;

    public static StartFragment newInstance() {
        return new StartFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_start, container, false);

        btnPlay = root.findViewById(R.id.btn_play);
        btnQuit = root.findViewById(R.id.btn_quit);

        btnPlay.setOnClickListener(this);
        btnQuit.setOnClickListener(this);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(StartViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play:
                rightToLeft();
                break;
            case R.id.btn_quit:
                bottomToUp();
                break;
            default:
                break;
        }
    }

    public void rightToLeft(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new PlayFragment()).commit();
        customType(getContext(),"right-to-left");
    }

    public void bottomToUp(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new SubjectsFragment()).commit();
        customType(getContext(),"bottom-to-up");
    }
}
