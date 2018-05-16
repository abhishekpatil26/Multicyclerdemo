package dev.abhishek.twowayrecycler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import dev.abhishek.twowayrecycler.ContentList;
import dev.abhishek.twowayrecycler.ItemVo;
import dev.abhishek.twowayrecycler.OnContentListUpdateListener;
import dev.abhishek.twowayrecycler.viewholder.row.BaseRowViewHolder;
import dev.abhishek.twowayrecycler.views.CellViewProvider;
import dev.abhishek.twowayrecycler.views.LayoutTypes;
import dev.abhishek.twowayrecycler.views.OnRecyclerItemClickListener;
import dev.abhishek.twowayrecycler.views.RowViewProvider;

/**
 * Created by abhishekpatil on 21/2/18.
 */

public class RowAdapter extends RecyclerView.Adapter<BaseRowViewHolder> implements OnContentListUpdateListener {

    private ContentList<ItemVo> musicItemList;
    private RowViewProvider rowViewProvider;
    private OnRecyclerItemClickListener onRecyclerItemClickListenerListener;

    public RowAdapter() {
        this.rowViewProvider = new RowViewProvider();
        this.musicItemList = new ContentList<ItemVo>();
        this.musicItemList.setOnContentListUpdateListener(this);
    }

    public void setData(ContentList<ItemVo> musicItemList, OnRecyclerItemClickListener onRecyclerItemClickListenerListener) {
        this.musicItemList = musicItemList;
        this.onRecyclerItemClickListenerListener = onRecyclerItemClickListenerListener;
        notifyDataSetChanged();
    }

    @Override
    public BaseRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = rowViewProvider.getRowView(parent, viewType);
        return rowViewProvider.getRowViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(BaseRowViewHolder holder, int position) {
        ItemVo musicItem = musicItemList.get(position);
        holder.bind(musicItem, position, new CellViewProvider(), onRecyclerItemClickListenerListener);
    }

    @Override
    public int getItemCount() {
        return musicItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return LayoutTypes.RowLayout.NORMAL;
    }

    @Override
    public void onContentListChanged() {
        notifyDataSetChanged();
    }

    @Override
    public void onContentListItemChanged(int position) {
        notifyItemChanged(position);
    }

    @Override
    public void onContentListItemRangeChanged(int positionStart, int itemCount) {
        notifyItemRangeChanged(positionStart, itemCount);
    }
}
