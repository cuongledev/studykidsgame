package com.cuongle.studykidsgame.ui.play;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.cuongle.studykidsgame.CustomAdapter;
import com.cuongle.studykidsgame.CustomResultAdapter;
import com.cuongle.studykidsgame.R;
import com.cuongle.studykidsgame.ui.slideshow.SlideshowViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class PlayFragment extends Fragment {

    private PlayViewModel mViewModel;

    private SlideshowViewModel slideshowViewModel;


    GridView simpleGrid,resultGrid;

    Map<Integer, Integer> results = new HashMap<Integer, Integer>();
    private String filename_result = "result.txt";

    //Thư mục do mình đặt
    private String filepath = "DataFreakingMath";
    File myInternalFile;


    int numbers[] = {R.drawable.num1, R.drawable.num2, R.drawable.num3, R.drawable.num4,
            R.drawable.num5, R.drawable.num6, R.drawable.num7, R.drawable.num8, R.drawable.num9};

    int asks[] = {R.drawable.ask1, R.drawable.ask2, R.drawable.ask3, R.drawable.ask4,
            R.drawable.ask5, R.drawable.ask6, R.drawable.ask7, R.drawable.ask8, R.drawable.ask9};


    int aws[] = {R.drawable.aw1, R.drawable.aw2, R.drawable.aw3, R.drawable.aw4,
            R.drawable.aw5, R.drawable.aw6, R.drawable.aw7, R.drawable.aw8, R.drawable.aw9};
    int colors[] = {R.drawable.color1, R.drawable.color2, R.drawable.color3, R.drawable.color4,
            R.drawable.color5, R.drawable.color6, R.drawable.color7, R.drawable.color8, R.drawable.color9};

    public static PlayFragment newInstance() {
        return new PlayFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_play, container, false);



        // add elements to map
        results.put(0, 2);
        results.put(1, 6);
        results.put(2, 7);
        results.put(3, 1);
        results.put(4, 3);
        results.put(5, 0);
        results.put(6, 8);
        results.put(7, 5);
        results.put(8, 4);


        ContextWrapper contextWrapper = new ContextWrapper(
                getContext());
        //Tạo (Hoặc là mở file nếu nó đã tồn tại) Trong bộ nhớ trong có thư mục là ThuMucCuaToi.
        File directory = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);
        myInternalFile = new File(directory, filename_result);
        if(myInternalFile.exists()) myInternalFile.delete();

        //write to file : "filename"
        try {
            //myInternalFile = new File(directory, filename);
            FileOutputStream fos=new FileOutputStream(myInternalFile);
            PrintWriter pw=new PrintWriter(fos);

            for(Map.Entry<Integer,Integer> m :results.entrySet()){
                pw.println(m.getKey()+"="+m.getValue());
            }

            pw.flush();
            pw.close();
            fos.close();
        } catch(Exception e) {}





        simpleGrid = (GridView) root.findViewById(R.id.simpleGridView); // init GridView
        resultGrid = (GridView) root.findViewById(R.id.resultGridView); // init GridView
        // Create an object of CustomAdapter and set Adapter to GirdView
        CustomAdapter customAdapter = new CustomAdapter(getContext(), numbers, asks);
        simpleGrid.setAdapter(customAdapter);
        // implement setOnItemClickListener event on GridView
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });



        // Create an object of CustomAdapter and set Adapter to GirdView
        CustomResultAdapter resultAdapter = new CustomResultAdapter(getContext(), aws, asks,colors);
        resultGrid.setAdapter(resultAdapter);
        // implement setOnItemClickListener event on GridView
        resultGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });




        return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PlayViewModel.class);
        // TODO: Use the ViewModel
    }

}
