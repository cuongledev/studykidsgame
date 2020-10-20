package com.cuongle.studykidsgame.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.cuongle.studykidsgame.R;
import com.cuongle.studykidsgame.ui.competition.CompetitionFragment;
import com.cuongle.studykidsgame.ui.gallery.GalleryFragment;
import com.cuongle.studykidsgame.ui.lesson.LessonFragment;
import com.cuongle.studykidsgame.ui.pratice.PraticeFragment;

import static androidx.core.content.ContextCompat.getDrawable;
import static maes.tech.intentanim.CustomIntent.customType;

public class HomeFragment extends Fragment {


    LinearLayout practice_item,competition_item,lesson_item;
    Button btn_continue, btn_cancel;
    private int state = 0;

    Animation fade;


    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        /*final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        practice_item = root.findViewById(R.id.practice_item);
        competition_item = root.findViewById(R.id.competition_item);
        lesson_item = root.findViewById(R.id.lesson_item);
        btn_continue = root.findViewById(R.id.btn_continue);
        btn_cancel = root.findViewById(R.id.btn_cancel);

        fade = AnimationUtils.loadAnimation(getContext(),R.anim.fade);
        btn_continue.setAlpha(0);
        btn_cancel.setAlpha(0);
        practice_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = 1;
                practice_item.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                competition_item.setBackground(getDrawable(getContext(),R.drawable.bg_item));
                lesson_item.setBackground(getDrawable(getContext(),R.drawable.bg_item));
                btn_continue.setAlpha(1);
                btn_cancel.setAlpha(1);
                btn_continue.startAnimation(fade);
            }
        });
        competition_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = 2;
                competition_item.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                practice_item.setBackground(getDrawable(getContext(),R.drawable.bg_item));
                lesson_item.setBackground(getDrawable(getContext(),R.drawable.bg_item));
                btn_continue.setAlpha(1);
                btn_cancel.setAlpha(1);
                btn_continue.startAnimation(fade);
            }
        });
        lesson_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = 3;
                lesson_item.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                practice_item.setBackground(getDrawable(getContext(),R.drawable.bg_item));
                competition_item.setBackground(getDrawable(getContext(),R.drawable.bg_item));
                btn_continue.setAlpha(1);
                btn_cancel.setAlpha(1);
                btn_continue.startAnimation(fade);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state = 0;
                practice_item.setBackground(getDrawable(getContext(),R.drawable.bg_item));
                competition_item.setBackground(getDrawable(getContext(),R.drawable.bg_item));
                lesson_item.setBackground(getDrawable(getContext(),R.drawable.bg_item));
                btn_continue.setAlpha(0);
                btn_cancel.setAlpha(0);
            }
        });


        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("STATE" , "STATE: " + state);
                switch (state){
                    case 1:
                        slideUp();
                        break;
                    case 2:
                        slideUpBottom();
                        break;
                    case 3:
                        leftToRight();
                        break;
                    default:
                        break;
                }

            }
        });

        return root;
    }

    public void slideUp(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new PraticeFragment()).commit();
        customType(getContext(),"bottom-to-up");
    }

    public void slideUpBottom(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new CompetitionFragment()).commit();
        customType(getContext(),"up-to-bottom");
    }

    public void leftToRight(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new LessonFragment()).commit();
        customType(getContext(),"left-to-right");
    }
}