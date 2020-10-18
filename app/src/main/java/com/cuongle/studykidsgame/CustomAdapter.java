package com.cuongle.studykidsgame;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int numbers[];
    int maths[];
    SharedPreferences sharedPref;

    Map<Integer, String> answers = new HashMap<Integer, String>();

    private String filename = "answers.txt";
    private String filename_ask = "asks.txt";

    //Thư mục do mình đặt
    private String filepath = "DataFreakingMath";
    File myInternalFile;


    //int clicked = 0;
    ArrayList<Integer> list;
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, int[] numbers, int[] maths) {
        this.context = applicationContext;
        this.numbers = numbers;
        this.maths = maths;
        inflter = (LayoutInflater.from(applicationContext));



    }

    @Override
    public int getCount() {
        return numbers.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_gridview, null); // inflate the layout
        final ImageView icon = (ImageView) view.findViewById(R.id.icon); // get the reference of ImageView
        icon.setImageResource(numbers[i]); // set logo images
        list = new ArrayList<Integer>();//Creating arraylist
        sharedPref = context.getSharedPreferences("DataFreaking", Context.MODE_PRIVATE);




        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon.setImageResource(maths[i]); // set logo images
                //Log.i("NUMBER", "Số id: " + i);
                //sharedPref.edit().clear().commit();

                //int clicked = sharedPref.getInt("CLICK_ASK", 0);

                if (!list.contains(i)) {
                    list.add(i);
                    if(list.size()==9){
                        ContextWrapper contextWrapper = new ContextWrapper( context.getApplicationContext());
                        //Tạo (Hoặc là mở file nếu nó đã tồn tại) Trong bộ nhớ trong có thư mục là ThuMucCuaToi.
                        File directory = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);
                        myInternalFile = new File(directory, filename_ask);
                        if(myInternalFile.exists()) myInternalFile.delete();

                        //write to file : "filename"
                        try {
                            //myInternalFile = new File(directory, filename);
                            FileOutputStream fos=new FileOutputStream(myInternalFile);
                            PrintWriter pw=new PrintWriter(fos);

                            for (Integer num : list) {
                                pw.println(num);
                            }

                            pw.flush();
                            pw.close();
                            fos.close();
                        } catch(Exception e) {}
                    }
                }





                //int total = sharedPref.getInt("CLICK_ASK", 0);
                //Toast.makeText(context.getApplicationContext(), "MESSAGE CLICKED ASK: " + total, Toast.LENGTH_LONG).show();







                /*ContextWrapper contextWrapper = new ContextWrapper(context.getApplicationContext());
                //Tạo (Hoặc là mở file nếu nó đã tồn tại) Trong bộ nhớ trong có thư mục là ThuMucCuaToi.
                File directory = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);
                myInternalFile = new File(directory, filename);


                //read from file
                try {
                    //File toRead=new File("filetwo.txt");
                    FileInputStream fis=new FileInputStream(myInternalFile);

                    Scanner sc=new Scanner(fis);

                    HashMap<Integer, Integer> mapInFile=new HashMap<>();

                    //read data from file line by line:
                    String currentLine;
                    while(sc.hasNextLine()) {
                        currentLine=sc.nextLine();
                        //now tokenize the currentLine:
                        StringTokenizer st=new StringTokenizer(currentLine,"=",false);
                        //put tokens ot currentLine in map
                        mapInFile.put(Integer.valueOf(st.nextToken()),Integer.valueOf(st.nextToken()));
                    }
                    fis.close();

                    //print All data in MAP
                    for(Map.Entry<Integer,Integer> entry :mapInFile.entrySet()) {
                        Log.i("HashMap", "HashMap Show ASKS: " + entry.getKey() + " - "+  entry.getValue());
                        //System.out.println(m.getKey()+" : "+m.getValue());
                    }
                }catch(Exception e) {}*/


                }


        });

        return view;
    }
}
