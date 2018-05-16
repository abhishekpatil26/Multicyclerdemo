package dev.abhishek.twowayrecycler.viewholder.row;

import android.support.v7.widget.GridLayoutManager;
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

public class GridRowViewHolder extends BaseRowViewHolder {

    private TextView            tvRowHeader;
    private TextView            tvSeeAll;
    private RecyclerView        gridRecycler;
    private static final int    NO_OF_COLUMNS = 2;

    public GridRowViewHolder(View itemView) {
        super(itemView);

        tvRowHeader     = getHeaderTextView();
        tvSeeAll        = getSeeAllTextView();
        gridRecycler    = getRecyclerView();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(itemView.getContext(), NO_OF_COLUMNS);
        gridRecycler.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void bind(ItemVo musicItem, int position, CellViewProvider cellViewProvider, OnRecyclerItemClickListener onRecyclerItemClickListener) {

        tvRowHeader.setText("Grid Row " + position);
        tvSeeAll.setVisibility(View.VISIBLE);
        gridRecycler.setAdapter(new CellAdapter(musicItem, cellViewProvider, onRecyclerItemClickListener));

    }

}
