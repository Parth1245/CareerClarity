package com.parth.careerclarity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CareerAdapter extends RecyclerView.Adapter<CareerAdapter.ViewHolder> {

    Context context;
    List<Career> list;

    public CareerAdapter(Context context, List<Career> list) {
        this.context = context;
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, desc;
        ImageView icon;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.txtTitle);
            desc = view.findViewById(R.id.txtDesc);
            icon = view.findViewById(R.id.icon);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_career, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Career c = list.get(position);

        holder.title.setText(c.title);
        holder.desc.setText(c.desc);

        // ✅ ICON LOGIC
        if (c.title.equals("Software Engineer")) {
            holder.icon.setImageResource(R.drawable.ic_code);
        } else if (c.title.equals("Data Analyst")) {
            holder.icon.setImageResource(R.drawable.ic_data);
        } else {
            holder.icon.setImageResource(R.drawable.ic_design);
        }

        // ✅ CLICK
        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, CareerDetailActivity.class);
            i.putExtra("title", c.title);
            context.startActivity(i);
        });

        // ✅ ANIMATION
        holder.itemView.setAnimation(
                AnimationUtils.loadAnimation(context, R.anim.item_anim)
        );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}