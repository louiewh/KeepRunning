package com.louiewh.keeprunning.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.louiewh.keeprunning.R;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HotRecyclerViewAdapter extends XRecyclerView.Adapter<HotRecyclerViewAdapter.HotViewHolder> {


    public HotRecyclerViewAdapter(Context context) {
    }

    @NonNull
    @Override
    public HotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HotViewHolder(
                LayoutInflater
                        .from(parent.getContext())
                        .inflate(R.layout.item_home_recycler, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HotViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class HotViewHolder extends XRecyclerView.ViewHolder {

        @BindView(R.id.card_home_recycler_item)
        public CardView mCardView;

        @BindView(R.id.tv_home_item)
        public TextView mTextViewHome;

        @BindView(R.id.img_home_item)
        public ImageView mImageView;

        public HotViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
