package com.kimduong.hometesttiki.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kimduong.hometesttiki.R;
import com.kimduong.hometesttiki.utils.UtilsColor;
import com.kimduong.hometesttiki.utils.UtilsString;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class KeywordAdapter extends RecyclerView.Adapter<KeywordAdapter.ViewHolder> {
    private List<String> mList;

    public KeywordAdapter() {
        mList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_keyword, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String keyword = UtilsString.parserTwoLine(mList.get(position));
        holder.cardView.setCardBackgroundColor(UtilsColor.getRandomColor());
        holder.tvKeyword.setText(keyword);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setList(List<String> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_keyword)
        TextView tvKeyword;
        @BindView(R.id.card_view)
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
