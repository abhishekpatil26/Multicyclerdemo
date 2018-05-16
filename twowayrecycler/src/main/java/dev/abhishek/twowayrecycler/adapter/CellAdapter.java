package dev.abhishek.twowayrecycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import dev.abhishek.twowayrecycler.ItemVo;
import dev.abhishek.twowayrecycler.viewholder.cell.BaseCellViewHolder;
import dev.abhishek.twowayrecycler.views.CellViewProvider;
import dev.abhishek.twowayrecycler.views.LayoutTypes;
import dev.abhishek.twowayrecycler.views.OnRecyclerItemClickListener;

/**
 * Created by abhishekpatil on 23/2/18.
 */

public class CellAdapter extends RecyclerView.Adapter<BaseCellViewHolder> {

    private ItemVo                      musicItem;
    private CellViewProvider            cellViewProvider;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public CellAdapter(ItemVo musicItem, CellViewProvider cellViewProvider, OnRecyclerItemClickListener onRecyclerItemClickListener) {
        this.musicItem = musicItem;
        this.cellViewProvider = cellViewProvider;
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;
    }

    @Override
    public BaseCellViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = cellViewProvider.getCellView(parent, viewType);
        return cellViewProvider.getCellViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(BaseCellViewHolder holder, int position) {
        holder.bind(musicItem, position, onRecyclerItemClickListener);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
        return LayoutTypes.CardLayout.NORMAL;
    }
}
