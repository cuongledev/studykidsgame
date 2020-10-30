package com.cuongle.studykidsgame.ui.group;

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
import com.cuongle.studykidsgame.ui.group_play.GroupPlayFragment;
import com.cuongle.studykidsgame.ui.subjects.SubjectsFragment;

import static androidx.core.content.ContextCompat.getDrawable;
import static maes.tech.intentanim.CustomIntent.customType;

public class GroupFragment extends Fragment implements View.OnClickListener {

    LinearLayout room_item1,room_item2,room_item3,room_item4,room_item5,room_item6,room_item7,room_item8;

    private GroupViewModel mViewModel;

    public static GroupFragment newInstance() {
        return new GroupFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_group, container, false);
        room_item1 = root.findViewById(R.id.room_item1);
        room_item2 = root.findViewById(R.id.room_item2);
        room_item3 = root.findViewById(R.id.room_item3);
        room_item4 = root.findViewById(R.id.room_item4);
        room_item5 = root.findViewById(R.id.room_item5);
        room_item6 = root.findViewById(R.id.room_item6);
        room_item7 = root.findViewById(R.id.room_item7);
        room_item8 = root.findViewById(R.id.room_item8);

        room_item1.setOnClickListener(this);
        room_item2.setOnClickListener(this);
        room_item3.setOnClickListener(this);
        room_item4.setOnClickListener(this);
        room_item5.setOnClickListener(this);
        room_item6.setOnClickListener(this);
        room_item7.setOnClickListener(this);
        room_item8.setOnClickListener(this);


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GroupViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.room_item1:
                room_item1.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.room_item2:
                room_item2.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.room_item3:
                room_item3.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.room_item4:
                room_item4.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.room_item5:
                room_item5.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.room_item6:
                room_item6.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.room_item7:
                room_item7.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            case R.id.room_item8:
                room_item8.setBackground(getDrawable(getContext(),R.drawable.bg_item_selected));
                rightToLeft();
                break;
            default:
                break;
        }
    }

    public void rightToLeft(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new GroupPlayFragment()).commit();
        customType(getContext(),"right-to-left");
    }
}