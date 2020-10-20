package com.cuongle.studykidsgame.ui.congratulations;

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
import android.widget.TextView;

import com.cuongle.studykidsgame.R;
import com.cuongle.studykidsgame.ui.play.PlayFragment;
import com.cuongle.studykidsgame.ui.subjects.SubjectsFragment;

import static maes.tech.intentanim.CustomIntent.customType;

public class CongrationsFragment extends Fragment {
    ImageView btn_play_again,btn_play_continue;

    TextView text_true,text_false;

    private CongrationsViewModel mViewModel;

    public static CongrationsFragment newInstance() {
        return new CongrationsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_congrations, container, false);


        Bundle bundle = getArguments();
        int result_true = bundle.getInt("RESULT_TRUE");
        int result_false = bundle.getInt("RESULT_FALSE");


        text_true = root.findViewById(R.id.text_true);
        text_false = root.findViewById(R.id.text_false);

        text_true.setText("Số câu đúng: " + result_true);
        text_false.setText("Số câu sai: " + result_false);

        btn_play_again = root.findViewById(R.id.btn_play_again);
        btn_play_continue = root.findViewById(R.id.btn_play_continue);
        btn_play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new PlayFragment()).commit();
                customType(getContext(),"right-to-left");
            }
        });

        btn_play_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new SubjectsFragment()).commit();
                customType(getContext(),"right-to-left");
            }
        });


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CongrationsViewModel.class);
        // TODO: Use the ViewModel
    }

}
