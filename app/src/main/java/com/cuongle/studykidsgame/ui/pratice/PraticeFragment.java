package com.cuongle.studykidsgame.ui.pratice;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import com.cuongle.studykidsgame.R;
import com.cuongle.studykidsgame.ui.play.PlayFragment;
import com.cuongle.studykidsgame.ui.slideshow.SlideshowFragment;
import com.cuongle.studykidsgame.ui.start.StartFragment;
import com.cuongle.studykidsgame.ui.subjects.SubjectsFragment;

import static maes.tech.intentanim.CustomIntent.customType;

public class PraticeFragment extends Fragment implements View.OnClickListener {

    CardView cv_one,cv_two,cv_three,cv_four,cv_five,cv_six;
    private int state = 0;
    Animation fade;

    private PraticeViewModel mViewModel;

    public static PraticeFragment newInstance() {
        return new PraticeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_pratice, container, false);


        cv_one = root.findViewById(R.id.cv_one);
        cv_two = root.findViewById(R.id.cv_two);
        cv_three = root.findViewById(R.id.cv_three);
        cv_four = root.findViewById(R.id.cv_four);
        cv_five = root.findViewById(R.id.cv_five);
        cv_six = root.findViewById(R.id.cv_six);

        cv_one.setOnClickListener(this);
        cv_two.setOnClickListener(this);
        cv_three.setOnClickListener(this);
        cv_four.setOnClickListener(this);
        cv_five.setOnClickListener(this);
        cv_six.setOnClickListener(this);


        return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PraticeViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cv_one:
                rightToLeft();
                break;
            case R.id.cv_two:
                rightToLeft();
                break;
            case R.id.cv_three:
                rightToLeft();
                break;
            case R.id.cv_four:
                rightToLeft();
                break;
            case R.id.cv_five:
                rightToLeft();
                break;
            case R.id.cv_six:
                rightToLeft();
                break;
            default:
                break;
        }
    }

    public void rightToLeft(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new SubjectsFragment()).commit();
        customType(getContext(),"right-to-left");
    }
}
