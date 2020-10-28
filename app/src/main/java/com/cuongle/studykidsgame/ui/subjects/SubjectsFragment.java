package com.cuongle.studykidsgame.ui.subjects;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cuongle.studykidsgame.HorizontalModel;
import com.cuongle.studykidsgame.R;
import com.cuongle.studykidsgame.VerticalModel;
import com.cuongle.studykidsgame.VerticalRecyclerViewAdapter;
import com.cuongle.studykidsgame.ui.play.PlayFragment;
import com.cuongle.studykidsgame.ui.start.StartFragment;

import java.util.ArrayList;

import static androidx.core.content.ContextCompat.getDrawable;
import static maes.tech.intentanim.CustomIntent.customType;

public class SubjectsFragment extends Fragment implements View.OnClickListener {

    RecyclerView verticalRecyclerView;
    VerticalRecyclerViewAdapter adapter;
    ArrayList<VerticalModel> arrayListVertical;

    ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9;

    private SubjectsViewModel mViewModel;

    public static SubjectsFragment newInstance() {
        return new SubjectsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_subjects, container, false);




        arrayListVertical = new ArrayList<>();

        verticalRecyclerView = root.findViewById(R.id.recyclerview);
        //verticalRecyclerView.setNestedScrollingEnabled(false);
        verticalRecyclerView.setHasFixedSize(true);


        verticalRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));


        adapter = new VerticalRecyclerViewAdapter(getContext(),arrayListVertical);

        verticalRecyclerView.setAdapter(adapter);
        setData();
        setDataMonTop();
        setDataMonNgon();


        /*imageView1 = root.findViewById(R.id.imageView1);
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
        imageView9.setOnClickListener(this);*/
        return root;
    }

    private void setData() {

        VerticalModel mVerticalModel = new VerticalModel();
        mVerticalModel.setTitle("Trải ngiệm cùng");
        ArrayList<HorizontalModel> arrayList = new ArrayList<>();

        for (int j=0;j<=5;j++){
            HorizontalModel mHorizontalModel = new HorizontalModel();
            //mHorizontalModel.setDescription("Description : " + j);
            switch (j){
                case 0:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b1));
                    mHorizontalModel.setName("Các số 1,2,3,4 5,6");
                    break;
                case 1:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b2));
                    mHorizontalModel.setName("Các số 7,8,9 0,10");
                    break;
                case 2:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b3));
                    mHorizontalModel.setName("So sánh các các số");
                    break;
                case 3:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b4));
                    mHorizontalModel.setName("Ôn tập đếm các số");
                    break;
                case 4:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b5));
                    mHorizontalModel.setName("Các số 7,8,10");
                    break;
                case 5:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b6));
                    mHorizontalModel.setName("Các số 1,2,4 5,6");
                    break;
                default:
                    break;
            }


            arrayList.add(mHorizontalModel);
        }

        mVerticalModel.setArrayList(arrayList);

        arrayListVertical.add(mVerticalModel);

        adapter.notifyDataSetChanged();

    }
    private void setDataMonTop() {
        VerticalModel mVerticalModel = new VerticalModel();
        mVerticalModel.setTitle("Các phép tính trong phạm vi 10");
        ArrayList<HorizontalModel> arrayList = new ArrayList<>();

        for (int j=0;j<=5;j++){
            HorizontalModel mHorizontalModel = new HorizontalModel();
            switch (j){
                case 0:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b1));
                    mHorizontalModel.setName("Câu hỏi tổng kết");
                    break;
                case 1:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b2));
                    mHorizontalModel.setName("Các số 1,2,3,4 5,6");
                    break;
                case 2:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b3));
                    mHorizontalModel.setName("So sánh các các số");
                    break;
                case 3:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b4));
                    mHorizontalModel.setName("Ôn tập đếm các số");
                    break;
                case 4:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b5));
                    mHorizontalModel.setName("Các số 7,8,10");
                    break;
                case 5:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b6));
                    mHorizontalModel.setName("Các số 1,2,4 5,6");
                    break;
                default:
                    break;
            }
            arrayList.add(mHorizontalModel);
        }

        mVerticalModel.setArrayList(arrayList);

        arrayListVertical.add(mVerticalModel);

        adapter.notifyDataSetChanged();

    }

    private void setDataMonNgon() {
        VerticalModel mVerticalModel = new VerticalModel();
        mVerticalModel.setTitle("Các số trong phạm vi 100");
        ArrayList<HorizontalModel> arrayList = new ArrayList<>();

        for (int j=0;j<=5;j++){
            HorizontalModel mHorizontalModel = new HorizontalModel();
            switch (j){
                case 0:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b1));
                    mHorizontalModel.setName("Ôn tập đếm các số");
                    break;
                case 1:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b2));
                    mHorizontalModel.setName("Câu hỏi tổng kết");
                    break;
                case 2:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b3));
                    mHorizontalModel.setName("So sánh các các số");
                    break;
                case 3:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b4));
                    mHorizontalModel.setName("Ôn tập đếm các số");
                    break;
                case 4:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b5));
                    mHorizontalModel.setName("Các số 7,8,10");
                    break;
                case 5:
                    mHorizontalModel.setBackground(getDrawable(getContext(),R.drawable.b6));
                    mHorizontalModel.setName("Các số 1,2,4 5,6");
                    break;
                default:
                    break;
            }
            arrayList.add(mHorizontalModel);
        }

        mVerticalModel.setArrayList(arrayList);

        arrayListVertical.add(mVerticalModel);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SubjectsViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        /*switch (v.getId()){
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
        }*/
    }

    public void rightToLeft(){
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment,new StartFragment()).commit();
        customType(getContext(),"right-to-left");
    }

}
