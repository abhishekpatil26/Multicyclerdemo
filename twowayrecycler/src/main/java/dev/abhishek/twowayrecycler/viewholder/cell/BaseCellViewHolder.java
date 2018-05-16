package dev.abhishek.twowayrecycler.viewholder.cell;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import dev.abhishek.twowayrecycler.ItemVo;
import dev.abhishek.twowayrecycler.R;
import dev.abhishek.twowayrecycler.views.OnRecyclerItemClickListener;

/**
 * Created by abhishekpatil on 23/2/18.
 */

public abstract class BaseCellViewHolder extends RecyclerView.ViewHolder {

    BaseCellViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bind(ItemVo content, int position, OnRecyclerItemClickListener onRecyclerItemClickListener);

    ImageView getContentImageView(){
        return itemView.findViewById(R.id.iv_content_image);
    }

    ImageView getContentPlayButton(){
        return itemView.findViewById(R.id.iv_play_btn);
    }

    TextView getContentTitle(){
        return itemView.findViewById(R.id.tv_content_title);
    }

    TextView getContentSubtitle(){
        return itemView.findViewById(R.id.tv_content_subtitle);
    }

    ImageView getContentMenu(){
        return itemView.findViewById(R.id.iv_content_menu);
    }

    ImageView getRadioIcon(){
        return itemView.findViewById(R.id.iv_radio_icon);
    }
}
