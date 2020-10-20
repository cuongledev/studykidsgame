package com.cuongle.studykidsgame.ui.lesson;

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

import com.cuongle.studykidsgame.R;
import com.cuongle.studykidsgame.ui.subjects.SubjectsFragment;
import com.cuongle.studykidsgame.ui.videos.VideosFragment;

import static maes.tech.intentanim.CustomIntent.customType;

public class LessonFragment extends Fragment implements View.OnClickListener {

    CardView vid_cv_one,vid_cv_two,vid_cv_three,vid_cv_four,vid_cv_five,vid_cv_six;

    private LessonViewModel mViewModel;

    public static LessonFragment newInstance() {
        return new LessonFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lesson, container, false);


        vid_cv_one = root.findViewById(R.id.vid_cv_one);
        vid_cv_two = root.findViewById(R.id.vid_cv_two);
        vid_cv_three = root.findViewById(R.id.vid_cv_three);
        vid_cv_four = root.findViewById(R.id.vid_cv_four);
        vid_cv_five = root.findViewById(R.id.vid_cv_five);
        vid_cv_six = root.findViewById(R.id.vid_cv_six);

        vid_cv_one.setOnClickListener(this);
        vid_cv_two.setOnClickListener(this);
        vid_cv_three.setOnClickListener(this);
        vid_cv_four.setOnClickListener(this);
        vid_cv_five.setOnClickListener(this);
        vid_cv_six.setOnClickListener(this);


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
            case R.id.vid_cv_one:
                rightToLeft();
                break;
            case R.id.vid_cv_two:
                rightToLeft();
                break;
            case R.id.vid_cv_three:
                rightToLeft();
                break;
            case R.id.vid_cv_four:
                rightToLeft();
                break;
            case R.id.vid_cv_five:
                rightToLeft();
                break;
            case R.id.vid_cv_six:
                rightToLeft();
                break;
            default:
                break;
        }
    }

    public void rightToLeft(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new VideosFragment()).commit();
        customType(getContext(),"right-to-left");
    }
}