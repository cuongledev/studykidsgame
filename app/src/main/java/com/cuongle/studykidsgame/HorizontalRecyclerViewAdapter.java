package com.cuongle.studykidsgame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.cuongle.studykidsgame.ui.congratulations.CongrationsFragment;
import com.cuongle.studykidsgame.ui.start.StartFragment;

import java.util.ArrayList;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<com.cuongle.studykidsgame.HorizontalRecyclerViewAdapter.HorizontalRVViewHolder>
{

    Context context;
    ArrayList<HorizontalModel> arrayList;

    public HorizontalRecyclerViewAdapter(Context context, ArrayList<HorizontalModel> arrayList)
    {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public HorizontalRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_horizontal,parent,false);


        return new HorizontalRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRVViewHolder holder, int position) {

        final HorizontalModel horizontalModel = arrayList.get(position);
        holder.textViewTitle.setText(horizontalModel.getName());
        holder.imageViewThumb.setBackground(horizontalModel.getBackground());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                StartFragment startFragment = new StartFragment();
                fragmentTransaction.replace(R.id.nav_host_fragment, startFragment).addToBackStack(null).commit();

                //Toast.makeText(context,horizontalModel.getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HorizontalRVViewHolder extends RecyclerView.ViewHolder
    {

        TextView textViewTitle;
        ImageView imageViewThumb;
        public HorizontalRVViewHolder(View itemView){
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.tvTitleHorizontal);
            imageViewThumb = itemView.findViewById(R.id.ivThum);
        }
    }

}
