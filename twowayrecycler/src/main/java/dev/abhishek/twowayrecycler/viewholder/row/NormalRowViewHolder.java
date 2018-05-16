package dev.abhishek.twowayrecycler.viewholder.row;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import dev.abhishek.twowayrecycler.ItemVo;
import dev.abhishek.twowayrecycler.adapter.CellAdapter;
import dev.abhishek.twowayrecycler.views.CellViewProvider;
import dev.abhishek.twowayrecycler.views.OnRecyclerItemClickListener;

/**
 * Created by abhishekpatil on 21/2/18.
 */

public class NormalRowViewHolder extends BaseRowViewHolder implements View.OnClickListener{

    private TextView                    tvRowHeader;
    private TextView                    tvSeeAll;
    private RecyclerView                horizontalRecycler;

    private ItemVo                      musicItem;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public NormalRowViewHolder(View itemView) {
        super(itemView);

        tvRowHeader         = getHeaderTextView();
        tvSeeAll            = getSeeAllTextView();
        horizontalRecycler  = getRecyclerView();

        LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecycler.setLayoutManager(layoutManager);
    }

    @Override
    public void bind(ItemVo musicItem, int position, CellViewProvider cellViewProvider, OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.musicItem = musicItem;
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;

        tvRowHeader.setText("Normal Row " + position);
        tvSeeAll.setVisibility(View.VISIBLE);
        tvSeeAll.setOnClickListener(this);
        horizontalRecycler.setAdapter(new CellAdapter(musicItem, cellViewProvider, onRecyclerItemClickListener));
    }

    @Override
    public void onClick(View view) {
        notifySeeALlClick();
    }

    private void notifySeeALlClick(){
        if(onRecyclerItemClickListener != null && musicItem != null){
            onRecyclerItemClickListener.onSeeAllPressed(musicItem);
        }
    }
}
