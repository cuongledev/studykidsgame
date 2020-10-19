package com.cuongle.studykidsgame.ui.subjects;

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
import com.cuongle.studykidsgame.ui.play.PlayFragment;
import com.cuongle.studykidsgame.ui.start.StartFragment;

import static maes.tech.intentanim.CustomIntent.customType;

public class SubjectsFragment extends Fragment implements View.OnClickListener {

    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;

    private SubjectsViewModel mViewModel;

    public static SubjectsFragment newInstance() {
        return new SubjectsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_subjects, container, false);


        imageView1 = root.findViewById(R.id.imageView1);
        imageView2 = root.findViewById(R.id.imageView2);
        imageView3 = root.findViewById(R.id.imageView3);
        imageView4 = root.findViewById(R.id.imageView4);
        imageView5 = root.findViewById(R.id.imageView5);
        imageView6 = root.findViewById(R.id.imageView6);
        imageView7 = root.findViewById(R.id.imageView7);
        imageView8 = root.findViewById(R.id.imageView8);
        imageView9 = root.findViewById(R.id.imageView9);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);
        imageView7.setOnClickListener(this);
        imageView8.setOnClickListener(this);
        imageView9.setOnClickListener(this);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SubjectsViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView1:
                rightToLeft();
                break;
            case R.id.imageView2:
                rightToLeft();
                break;
            case R.id.imageView3:
                rightToLeft();
                break;
            case R.id.imageView4:
                rightToLeft();
                break;
            case R.id.imageView5:
                rightToLeft();
                break;
            case R.id.imageView6:
                rightToLeft();
                break;
            default:
                rightToLeft();
                break;
        }
    }

    public void rightToLeft(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new StartFragment()).commit();
        customType(getContext(),"right-to-left");
    }

}
