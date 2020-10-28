package com.cuongle.studykidsgame.ui.competition;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
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
import com.cuongle.studykidsgame.ui.group.GroupFragment;
import com.cuongle.studykidsgame.ui.roomone.RoomoneFragment;
import com.cuongle.studykidsgame.ui.subjects.SubjectsFragment;

import static androidx.core.content.ContextCompat.getDrawable;
import static maes.tech.intentanim.CustomIntent.customType;

public class CompetitionFragment extends Fragment {

    LinearLayout one_item,group_item;

    private CompetitionViewModel mViewModel;

    public static CompetitionFragment newInstance() {
        return new CompetitionFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_competition, container, false);

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle("Thi đấu");


        one_item = root.findViewById(R.id.one_item);
        one_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one_item.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected_7));
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, new RoomoneFragment()).commit();
                customType(getContext(),"right-to-left");
            }
        });

        group_item = root.findViewById(R.id.group_item);
        group_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                group_item.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected_7));
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment, new GroupFragment()).commit();
                customType(getContext(),"right-to-left");
            }
        });




        return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CompetitionViewModel.class);
        // TODO: Use the ViewModel
    }

}