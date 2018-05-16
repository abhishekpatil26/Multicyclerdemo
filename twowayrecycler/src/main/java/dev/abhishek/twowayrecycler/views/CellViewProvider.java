package dev.abhishek.twowayrecycler.views;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.abhishek.twowayrecycler.R;
import dev.abhishek.twowayrecycler.viewholder.cell.BaseCellViewHolder;
import dev.abhishek.twowayrecycler.viewholder.cell.NormalCellViewHolder;

/**
 * Created by abhishekpatil on 23/2/18.
 */

public class CellViewProvider {

    public CellViewProvider() {}

    @Nullable
    public View getCellView(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case LayoutTypes.CardLayout.NORMAL:
            return inflater.inflate(R.layout.card_layout, parent, false);

        }
        return null;
    }

    @Nullable
    public BaseCellViewHolder getCellViewHolder(View view, int viewType) {
        switch (viewType){
            case LayoutTypes.CardLayout.NORMAL:
                return new NormalCellViewHolder(view);
        }
        return null;
    }
}
