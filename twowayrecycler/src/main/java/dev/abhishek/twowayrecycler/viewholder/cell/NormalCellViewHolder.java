package dev.abhishek.twowayrecycler.viewholder.cell;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import dev.abhishek.twowayrecycler.ItemVo;
import dev.abhishek.twowayrecycler.R;
import dev.abhishek.twowayrecycler.views.OnRecyclerItemClickListener;

/**
 * Created by abhishekpatil on 23/2/18.
 */

public class NormalCellViewHolder extends BaseCellViewHolder implements View.OnClickListener, View.OnLongClickListener{

    private ImageView                   imgRadioIcon;
    private ImageView                   imgContentImage;
    private ImageView                   imgPlayBtn;
    private TextView                    tvContentTitle;
    private TextView                    tvContentSubtitle;
    private ImageView                   imgMenu;

    private ItemVo                      content;
    private int                         position;
    private OnRecyclerItemClickListener onRecyclerItemClickListener;

    public NormalCellViewHolder(View itemView) {
        super(itemView);

        imgRadioIcon        = getRadioIcon();
        imgContentImage     = getContentImageView();
        imgPlayBtn          = getContentPlayButton();
        tvContentTitle      = getContentTitle();
        tvContentSubtitle   = getContentSubtitle();
        imgMenu             = getContentMenu();
    }


    @Override
    public void bind(ItemVo content, int position, OnRecyclerItemClickListener onRecyclerItemClickListener) {

        this.content = content;
        this.position = position;
        this.onRecyclerItemClickListener = onRecyclerItemClickListener;

        // set listeners
        super.itemView.setOnClickListener(this);
        super.itemView.setOnLongClickListener(this);
        imgMenu.setOnClickListener(this);

        //binding data to views
        imgRadioIcon.setVisibility(View.VISIBLE);

        imgPlayBtn.setVisibility(View.VISIBLE);
        tvContentTitle.setText("Title");
        tvContentSubtitle.setText("SubTitle");
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.iv_content_menu){
            notifyOnLongClick();
        } else {
            notifyOnClick();
        }
    }

    @Override
    public boolean onLongClick(View view) {
        notifyOnLongClick();
        return true;
    }

    private void notifyOnClick(){
        if(onRecyclerItemClickListener != null && content != null){
            onRecyclerItemClickListener.onItemClick(content);
        }
    }

    private void notifyOnLongClick(){
        if(onRecyclerItemClickListener != null && content != null){
            onRecyclerItemClickListener.onItemLongClick(content, position);
        }
    }
}
