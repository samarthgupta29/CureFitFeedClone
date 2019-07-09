package com.example.curefitfeed.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.curefitfeed.Model.CultunlimitedmembershipDetail;
import com.example.curefitfeed.R;

import java.util.ArrayList;

public class CultunlimitedmembershipDetailArrayListAdapter extends RecyclerView.Adapter<CultunlimitedmembershipDetailArrayListAdapter.CultunlimitedmembershipDetailArrayListViewHolder> {

    private Context context;
    private ArrayList<CultunlimitedmembershipDetail> detailArrayList;

    public CultunlimitedmembershipDetailArrayListAdapter(Context context, ArrayList<CultunlimitedmembershipDetail> detailArrayList) {
        this.context = context;
        this.detailArrayList = detailArrayList;
    }

    @NonNull
    @Override
    public CultunlimitedmembershipDetailArrayListAdapter.CultunlimitedmembershipDetailArrayListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mind_unlimited_card_item,parent,false);
        return new CultunlimitedmembershipDetailArrayListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CultunlimitedmembershipDetailArrayListAdapter.CultunlimitedmembershipDetailArrayListViewHolder holder, int position) {
        CultunlimitedmembershipDetail cultunlimitedmembershipDetail = detailArrayList.get(position);
        holder.textView5.setText(cultunlimitedmembershipDetail.getPrice());
        holder.textView6.setText(cultunlimitedmembershipDetail.getOfferPrice());
        Glide.with(context).load(cultunlimitedmembershipDetail.getImageUrl()).centerCrop().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return detailArrayList.size();
    }

    public class CultunlimitedmembershipDetailArrayListViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView4,textView5,textView6,textView7;
        public CultunlimitedmembershipDetailArrayListViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView4 = itemView.findViewById(R.id.textView4);
            textView5 = itemView.findViewById(R.id.textView5);
            textView6 = itemView.findViewById(R.id.textView6);
            textView7 = itemView.findViewById(R.id.textView7);
        }
    }
}
