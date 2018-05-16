package dev.abhishek.twowayrecycler.viewholder.row;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import dev.abhishek.twowayrecycler.ItemVo;
import dev.abhishek.twowayrecycler.R;
import dev.abhishek.twowayrecycler.views.CellViewProvider;
import dev.abhishek.twowayrecycler.views.OnRecyclerItemClickListener;

/**
 * Created by abhishekpatil on 21/2/18.
 */

public abstract class BaseRowViewHolder extends RecyclerView.ViewHolder{

    BaseRowViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(ItemVo musicItem, int position, CellViewProvider cellViewProvider, OnRecyclerItemClickListener onRecyclerItemClickListener);

    RecyclerView getRecyclerView(){
        return (RecyclerView) itemView.findViewById(R.id.rv_cell_list);
    }

    TextView getHeaderTextView(){
        return (TextView) itemView.findViewById(R.id.tv_row_header);
    }

    TextView getSeeAllTextView(){
        return (TextView) itemView.findViewById(R.id.tv_see_all);
    }
}
