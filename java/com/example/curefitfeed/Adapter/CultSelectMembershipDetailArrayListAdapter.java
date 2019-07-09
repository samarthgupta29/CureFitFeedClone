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
import com.example.curefitfeed.Model.CultselectmembershipDetail;
import com.example.curefitfeed.R;

import java.util.ArrayList;

public class CultSelectMembershipDetailArrayListAdapter extends RecyclerView.Adapter<CultSelectMembershipDetailArrayListAdapter.CultSelectMembershipDetailArrayListViewHolder> {

    private Context context;
    private ArrayList<CultselectmembershipDetail> detailArrayList;

    public CultSelectMembershipDetailArrayListAdapter(Context context, ArrayList<CultselectmembershipDetail> detailArrayList) {
        this.context = context;
        this.detailArrayList = detailArrayList;
    }

    @NonNull
    @Override
    public CultSelectMembershipDetailArrayListAdapter.CultSelectMembershipDetailArrayListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.mind_unlimited_card_item,parent,false);
        return new CultSelectMembershipDetailArrayListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CultSelectMembershipDetailArrayListAdapter.CultSelectMembershipDetailArrayListViewHolder holder, int position) {
        CultselectmembershipDetail cultselectmembershipDetail = detailArrayList.get(position);
        Glide.with(context).load(cultselectmembershipDetail.getImageUrl()).centerCrop().into(holder.imageView);
        holder.textView5.setText(cultselectmembershipDetail.getPrice());
        holder.textView7.setText(cultselectmembershipDetail.getOfferPrice());
    }

    @Override
    public int getItemCount() {
        return detailArrayList.size();
    }

    public class CultSelectMembershipDetailArrayListViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView4,textView5,textView6,textView7;

        public CultSelectMembershipDetailArrayListViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView4 = itemView.findViewById(R.id.textView4);
            textView5 = itemView.findViewById(R.id.textView5);
            textView6 = itemView.findViewById(R.id.textView6);
            textView7 = itemView.findViewById(R.id.textView7);
        }
    }
}
