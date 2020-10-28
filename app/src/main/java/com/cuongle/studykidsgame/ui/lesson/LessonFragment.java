package com.cuongle.studykidsgame.ui.lesson;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cuongle.studykidsgame.R;
import com.cuongle.studykidsgame.ui.subjects.SubjectsFragment;
import com.cuongle.studykidsgame.ui.videos.VideosFragment;

import static maes.tech.intentanim.CustomIntent.customType;

public class LessonFragment extends Fragment implements View.OnClickListener {

    LinearLayout tv_cd_item,tv_nl_item,tv_bd_item,tv_ct_item,tv_kn_item,tv_kn_item1,tv_kn_item2,tv_kn_item3;

    private LessonViewModel mViewModel;

    public static LessonFragment newInstance() {
        return new LessonFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lesson, container, false);


        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Bài giảng");

        tv_cd_item = root.findViewById(R.id.tv_cd_item);
        tv_nl_item = root.findViewById(R.id.tv_nl_item);
        tv_bd_item = root.findViewById(R.id.tv_bd_item);
        tv_ct_item = root.findViewById(R.id.tv_ct_item);
        tv_kn_item = root.findViewById(R.id.tv_kn_item);
        tv_kn_item1 = root.findViewById(R.id.tv_kn_item1);
        tv_kn_item2 = root.findViewById(R.id.tv_kn_item2);
        tv_kn_item3 = root.findViewById(R.id.tv_kn_item3);

        tv_cd_item.setOnClickListener(this);
        tv_nl_item.setOnClickListener(this);
        tv_bd_item.setOnClickListener(this);
        tv_ct_item.setOnClickListener(this);
        tv_kn_item.setOnClickListener(this);
        tv_kn_item1.setOnClickListener(this);
        tv_kn_item2.setOnClickListener(this);
        tv_kn_item3.setOnClickListener(this);


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LessonViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_cd_item:
                rightToLeft();
                break;
            case R.id.tv_nl_item:
                rightToLeft();
                break;
            default:
                rightToLeft();
                break;
        }
    }

    public void rightToLeft(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new VideosFragment()).commit();
        customType(getContext(),"right-to-left");
    }


}