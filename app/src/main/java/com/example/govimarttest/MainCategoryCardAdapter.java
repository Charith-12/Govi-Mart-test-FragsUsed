package com.example.govimarttest;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainCategoryCardAdapter extends RecyclerView.Adapter<MainCategoryCardAdapter.MainCategoryCardViewHolder> {
    private ArrayList<MainCategoryCard> mCategoryList;
    public static class MainCategoryCardViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;

        public MainCategoryCardViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.categoryImageView);
            mTextView1 = itemView.findViewById(R.id.categoryTextView);

            // On Click Listener for card
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //
                    String cardText = mTextView1.getText().toString();

                    if(cardText.equalsIgnoreCase("Vegetables")){
                        v.getContext().startActivity(new Intent(v.getContext(), ShowVegetablesActivity.class));
                    }

                    //
                    //TODO activities & Create intents for other cards too

                }
            });

        }
    }

    //Constructor
    public MainCategoryCardAdapter(ArrayList<MainCategoryCard> categoryList) {
        mCategoryList = categoryList;
    }

    @Override
    public MainCategoryCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_category_card, parent, false);
        MainCategoryCardViewHolder categoryViewHolder = new MainCategoryCardViewHolder(v);
        return categoryViewHolder;
    }
    @Override
    public void onBindViewHolder(MainCategoryCardViewHolder holder, int position) {
        MainCategoryCard currentItem = mCategoryList.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        
    }
    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }
}
