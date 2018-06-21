package com.example.h_mamytov.callbackwithtwofragments.Adapter;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.h_mamytov.callbackwithtwofragments.Fragment.FragmentOne;
import com.example.h_mamytov.callbackwithtwofragments.R;

public class AdapterOne extends RecyclerView.Adapter<AdapterOne.ItemClickViewHolder>{

    ChangeFragmentTwoBackgroundCallback callback;

    private final int color = 16711680;


    public void changeBackGround(){
      FragmentOne.getImageView().setBackgroundColor(color);
      callback.changeBackGroundOfFragmentTwo();
    }

    @NonNull
    @Override
    public ItemClickViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);

        return new ItemClickViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemClickViewHolder itemClickViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemClickViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ItemClickListener itemClickListener;


        public ItemClickViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition());
        }

        void setItemClickListener(ItemClickListener clickListener){
            this.itemClickListener = clickListener;
        }
    }

    public interface ChangeFragmentTwoBackgroundCallback{
        void changeBackGroundOfFragmentTwo();
    }

    public void setCallback(ChangeFragmentTwoBackgroundCallback callback) {
        this.callback = callback;
    }
}
