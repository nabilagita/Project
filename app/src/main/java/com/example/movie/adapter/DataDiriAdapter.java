package com.example.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movie.Databse.DataDiri;
import com.example.movie.R;
import com.example.movie.UpdateActivity;

public class DataDiriAdapter extends RecyclerView.Adapter<DataDiriAdapter.DataDiriViewHolder> {
    private DataDiri[] list;
    private Context context;

    public DataDiriAdapter(DataDiri[] list,Context context){
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public DataDiriViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_datadiri, parent, false);
        return new DataDiriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataDiriViewHolder holder, int position) {
        final DataDiri item = list[position];

        holder.tvEmail.setText(item.getEmail());
        holder.tvPassword.setText(item.getPassword());

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", item.getId());
                intent.putExtra("email", item.getEmail());
                intent.putExtra("password", item.getPassword());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.length;
    }

    public class DataDiriViewHolder extends RecyclerView.ViewHolder {
       TextView tvEmail,  tvPassword;
       View itemView;
       LinearLayout itemLayout;

        public DataDiriViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmail = itemView.findViewById(R.id.tv_email);
            tvPassword = itemView.findViewById(R.id.tv_password);
            itemLayout = itemView.findViewById(R.id.item_layout);

            this.itemView = itemView;
        }
    }
}
