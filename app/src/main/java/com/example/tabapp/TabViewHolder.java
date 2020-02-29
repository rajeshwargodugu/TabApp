package com.example.tabapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class TabViewHolder extends RecyclerView.ViewHolder {

    public TextView mTabRowTextView;

    public TabViewHolder(@NonNull View itemView) {
        super(itemView);
        mTabRowTextView = itemView.findViewById(R.id.tab_row_item);
    }
}
