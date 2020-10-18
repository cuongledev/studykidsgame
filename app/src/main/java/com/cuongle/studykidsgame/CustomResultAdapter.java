package com.cuongle.studykidsgame;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.cuongle.studykidsgame.ui.congratulations.CongrationsFragment;
import com.cuongle.studykidsgame.ui.pratice.PraticeFragment;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static maes.tech.intentanim.CustomIntent.customType;

public class CustomResultAdapter extends BaseAdapter {

    Context context;
    int numbers[];
    int maths[];
    int colors[];

    SharedPreferences sharedPref;

    Map<Integer, String> answers = new HashMap<Integer, String>();
    Map<Integer, Integer> finals = new HashMap<Integer, Integer>();
    Map<Integer, Integer> mapData = new HashMap<Integer, Integer>();

    ArrayList<Integer> listTrue,listFalse;

    //Intent intent;

    private String filename_result = "result.txt";
    private String filename_ask = "asks.txt";

    //Thư mục do mình đặt
    private String filepath = "DataFreakingMath";
    File myFileASK,myFileResult;

    ArrayList<Integer> list;
    LayoutInflater inflter;

    public CustomResultAdapter(Context applicationContext, int[] numbers, int[] maths, int[] colors) {
        this.context = applicationContext;
        this.numbers = numbers;
        this.maths = maths;
        this.colors = colors;
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
        //intent = new Intent(context, Congratulations.class);

        final View finalView = view;
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icon.setImageResource(colors[i]); // set logo images
                //Log.i("NUMBER", "Số id: " + i);
                //sharedPref.edit().clear().commit();
                int clicked = sharedPref.getInt("CLICK_ANSWER", 0);

                if (!list.contains(i)) {
                    list.add(i);
                }





                //int total = sharedPref.getInt("CLICK_ANSWER", 0);


                ContextWrapper contextWrapper = new ContextWrapper(context.getApplicationContext());
                //Tạo (Hoặc là mở file nếu nó đã tồn tại) Trong bộ nhớ trong có thư mục là ThuMucCuaToi.
                File directory = contextWrapper.getDir(filepath, Context.MODE_PRIVATE);

                if (list.size()==9){
                    //Toast.makeText(context.getApplicationContext(), "MESSAGE CLICKED ANSWER: " + list.size(), Toast.LENGTH_LONG).show();
                    // kiểm tra đối chiếu kết quả

                    /*int j = 0;
                    for (Integer numi : list) {
                        Log.i("NUMBER", "CAU TRA LOI DA CHON ARRAY_AWS: " + j + " - " + numi);
                        j++;
                    }*/


                    myFileASK = new File(directory, filename_ask);
                    //read from file câu hỏi
                    try {
                        //File toRead=new File("filetwo.txt");
                        FileInputStream fis=new FileInputStream(myFileASK);

                        Scanner sc=new Scanner(fis);

                        ArrayList<Integer> mapInFile=new ArrayList<Integer>();
                        //HashMap<Integer, Integer> mapInFile=new HashMap<>();

                        //read data from file line by line:
                        String currentLine;
                        while(sc.hasNextLine()) {
                            currentLine=sc.nextLine();
                            //now tokenize the currentLine:
                            StringTokenizer st=new StringTokenizer(currentLine,"=",false);
                            //put tokens ot currentLine in map
                            mapInFile.add(Integer.valueOf(st.nextToken()));
                        }
                        fis.close();

                        //print All data in MAP

                        mapData =new HashMap<Integer, Integer>();

                        int i = 0;
                        for (Integer num : mapInFile) {
                            mapData.put(num,list.get(i));
                            //Log.i("NUMBER", "CAU HOI DA CHON ARRAY_ASK, CAU " + i + ": " + num + " - " + list.get(i));
                            //System.out.println(m.getKey()+" : "+m.getValue());
                            i++;
                        }


                        //Iterator itr= diff.keySet().iterator();
                        /*while(itr.hasNext())
                        {
                            int key=(int)itr.next();
                            //System.out.println("Roll no:  "+key+"     name:   "+mapData.get(key));
                        }*/





                }catch(Exception e) {}

                    //read from file kết quả
                    myFileResult = new File(directory, filename_result);
                    try {
                        //File toRead=new File("filetwo.txt");
                        FileInputStream fis=new FileInputStream(myFileResult);

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

                        listTrue = new ArrayList<Integer>();
                        listFalse = new ArrayList<Integer>();
                        TreeMap<Integer,Integer> diff = new  TreeMap<Integer,Integer> (mapData);

                        //print All data in MAP
                        for(Map.Entry<Integer,Integer> entry :mapInFile.entrySet()) {
                            if(entry.getValue().equals(diff.get(entry.getKey()))){
                                listTrue.add(entry.getKey());
                            }else{
                                listFalse.add(entry.getKey());
                            }
                            Log.i("NUMBER", "HashMap Show Result: " + entry.getKey() + " - "+  entry.getValue());

                            //System.out.println(m.getKey()+" : "+m.getValue());
                        }

                        //Toast.makeText(contextWrapper, "Oki " + listTrue.size() + " - "+  listFalse.size(), Toast.LENGTH_SHORT).show();
                        Log.i("NUMBER", "List: " + listTrue.size() + " - "+  listFalse.size());
                        //intent.putExtra("RESULT_TRUE",listTrue.size());
                        //intent.putExtra("RESULT_FALSE",listFalse.size());


                        Bundle bundle = new Bundle();
                        bundle.putInt("RESULT_TRUE", listTrue.size());
                        bundle.putInt("RESULT_FALSE", listFalse.size());


                        /*SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putInt("RESULT_TRUE", listTrue.size());
                        editor.putInt("RESULT_FALSE", listFalse.size());
                        editor.commit();*/
                        Log.i("NUMBER", "MESSAGE: Số câu đúng: " + listTrue.size() + " - Câu sai: " +listFalse.size());
                        FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                        CongrationsFragment congrationsFragment = new CongrationsFragment();
                        congrationsFragment.setArguments(bundle);

                        fragmentTransaction.replace(R.id.nav_host_fragment, congrationsFragment).addToBackStack(null).commit();
                        //customType(context.getApplicationContext(),"bottom-to-up");


                        /*Intent intent = new Intent(context.getApplicationContext(),Congratulations.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        intent.putExtra("RESULT_TRUE",listTrue.size() + "");
                        intent.putExtra("RESULT_FALSE",listFalse.size() + "");
                        context.getApplicationContext().startActivity(intent);
                        ((Activity)context).finish();*/


                        //context.startActivity(intent);

                        /*Log.i("NUMBER", "MESSAGE: Số câu đúng: " + listTrue.size() + " - Câu sai: " +listFalse.size());
                        Toast.makeText(context.getApplicationContext(), "MESSAGE: Số câu đúng: " + listTrue.size() + " - Câu sai: " +listFalse.size(), Toast.LENGTH_LONG).show();


                        for(Map.Entry<Integer,Integer> entry :diff.entrySet()) {
                            Log.i("NUMBER", "HashMap Show Click Result: " + entry.getKey() + " - "+  entry.getValue());
                        }*/

                    }catch(Exception e) {}

                }









            }
        });

        return view;
    }
}
