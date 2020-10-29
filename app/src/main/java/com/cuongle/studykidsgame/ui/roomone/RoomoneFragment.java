package com.cuongle.studykidsgame.ui.roomone;

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
import com.cuongle.studykidsgame.ui.pratice.PraticeFragment;
import com.cuongle.studykidsgame.ui.rival.RivalFragment;

import static maes.tech.intentanim.CustomIntent.customType;

public class RoomoneFragment extends Fragment implements View.OnClickListener {

    LinearLayout item_invite1;

    private RoomoneViewModel mViewModel;

    public static RoomoneFragment newInstance() {
        return new RoomoneFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_roomone, container, false);
        item_invite1 = root.findViewById(R.id.item_invite1);


        item_invite1.setOnClickListener(this);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RoomoneViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.item_invite1:
                FragmentManager fragmentManager = getParentFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new RivalFragment()).commit();
                customType(getContext(),"bottom-to-up");
                break;

                default:
                    break;
        }
    }
}