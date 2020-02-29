package com.example.tabapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TabRecyclerAdapter extends RecyclerView.Adapter<TabViewHolder> {

  public ArrayList<String> dataList;
  TabRecyclerAdapter(ArrayList data) {
      this.dataList = data;

  }

    @NonNull
    @Override
    public TabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      // inflate the item layout when using multiple view holder return different view holder or generic
      View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_item_row, parent, false);
      //sets the view to view holder
      TabViewHolder tvh = new TabViewHolder(v);
      return  tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TabViewHolder holder, int position) {
        holder.mTabRowTextView.setText(dataList.get(position));
    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
