package com.mirea.lukyanovea.mireaproject.ui.stories;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.mirea.lukyanovea.mireaproject.R;


public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView txtName;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txt_name);
    }
}