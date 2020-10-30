package com.cuongle.studykidsgame.ui.rival;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

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

import static androidx.core.content.ContextCompat.getDrawable;
import static maes.tech.intentanim.CustomIntent.customType;

public class RivalFragment extends Fragment implements View.OnClickListener {

    LinearLayout cv_one,cv_two,cv_three,cv_four,cv_five,cv_six,cv_seven,cv_eight;

    private RivalViewModel mViewModel;

    public static RivalFragment newInstance() {
        return new RivalFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_rival, container, false);

        cv_one = root.findViewById(R.id.cv_one);
        cv_two = root.findViewById(R.id.cv_two);
        cv_three = root.findViewById(R.id.cv_three);
        cv_four = root.findViewById(R.id.cv_four);
        cv_five = root.findViewById(R.id.cv_five);
        cv_six = root.findViewById(R.id.cv_six);
        cv_seven = root.findViewById(R.id.cv_seven);
        cv_eight = root.findViewById(R.id.cv_eight);

        cv_one.setOnClickListener(this);
        cv_two.setOnClickListener(this);
        cv_three.setOnClickListener(this);
        cv_four.setOnClickListener(this);
        cv_five.setOnClickListener(this);
        cv_six.setOnClickListener(this);
        cv_seven.setOnClickListener(this);
        cv_eight.setOnClickListener(this);


        return root;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RivalViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cv_one:
                cv_one.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.cv_two:
                cv_two.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.cv_three:
                cv_three.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.cv_four:
                cv_four.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.cv_five:
                cv_five.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.cv_six:
                cv_six.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.cv_seven:
                cv_seven.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.cv_eight:
                cv_eight.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
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
