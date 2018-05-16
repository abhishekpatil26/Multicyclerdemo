package dev.abhishek.twowayrecycler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import dev.abhishek.twowayrecycler.adapter.RowAdapter;
import dev.abhishek.twowayrecycler.views.OnRecyclerItemClickListener;

/**
 * Created by abhishekpatil on 21/2/18.
 */

public class TwoWayRecycler extends RecyclerView {

    public TwoWayRecycler(Context context) {
        super(context);
    }

    public TwoWayRecycler(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TwoWayRecycler(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        this.setLayoutManager(layoutManager);
        this.scrollToPosition(0);
        this.setNestedScrollingEnabled(false);
    }

    public void setRowData(ContentList<ItemVo> itemVos, OnRecyclerItemClickListener onRecyclerItemClickListenerListener){

        RowAdapter rowAdapter = null;

        if(this.getAdapter() != null){
            rowAdapter.setData(itemVos, onRecyclerItemClickListenerListener);
        } else {
            rowAdapter = new RowAdapter();
            this.setAdapter(rowAdapter);
            rowAdapter.setData(itemVos, onRecyclerItemClickListenerListener);
        }

    }
}
