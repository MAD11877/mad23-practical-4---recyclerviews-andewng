package com.example.week2prac;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class myAdapter extends RecyclerView.Adapter<myViewHolder>{
    ArrayList<User> usersList;
    AlertDialog.Builder builder;
    TextView nametxt;
    TextView destxt;
    public myAdapter(ArrayList<User> userList) { this.usersList = userList;

    }
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,
                parent,
                false);
        return new myViewHolder(item);

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        String name = usersList.get(position).getName();
        String desc = usersList.get(position).getDescription();
        holder.nametxt.setText(name);
        holder.destxt.setText(desc);

    }



    @Override
    public int getItemCount() {return usersList.size();
    }
}
