package dev.abhishek.twowayrecycler.views;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.abhishek.twowayrecycler.R;
import dev.abhishek.twowayrecycler.viewholder.row.BaseRowViewHolder;
import dev.abhishek.twowayrecycler.viewholder.row.GridRowViewHolder;
import dev.abhishek.twowayrecycler.viewholder.row.NormalRowViewHolder;

/**
 * Created by abhishekpatil on 22/2/18.
 */

public class RowViewProvider {

    public RowViewProvider() {}

    @NonNull
    public View getRowView(ViewGroup parent, int rowType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            switch (rowType){
                case LayoutTypes.RowLayout.NORMAL:
                case LayoutTypes.RowLayout.GRID:
                    return inflater.inflate(R.layout.row_layout, parent, false);
            }
        return inflater.inflate(R.layout.row_layout, parent, false);
    }

    @NonNull
    public BaseRowViewHolder getRowViewHolder(View view, int rowType) {
        switch (rowType){
            case LayoutTypes.RowLayout.NORMAL:
                return new NormalRowViewHolder(view);
            case LayoutTypes.RowLayout.GRID:
                return new GridRowViewHolder(view);
        }
        return new NormalRowViewHolder(view);
    }
}
