package com.example.simpletodo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    public  interface OnClickListener{
        void onItemClicked(int position);
    }
    public interface OnLongClickListener{
        void onItemLonClicked(int position);
    }
    List<String> items;
    OnLongClickListener longClickListener;
    OnClickListener clickListener;
    public ItemsAdapter(List<String> items, OnLongClickListener longClickListener,OnClickListener clickListener) {
        this.items= items;
        this.longClickListener=longClickListener;
        this.clickListener= clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View TodoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        return new ViewHolder(TodoView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
  String item= items.get(position);
   holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvIdem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIdem= itemView.findViewById(android.R.id.text1);
        }

        public void bind(String item) {
            tvIdem.setText(item);
            tvIdem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  clickListener.onItemClicked(getAdapterPosition());
                }
            });
          tvIdem.setOnLongClickListener(new View.OnLongClickListener() {
              @Override
              public boolean onLongClick(View v) {
                  longClickListener.onItemLonClicked(getAdapterPosition());
                  return true;
              }
          });
        }
    }
}
