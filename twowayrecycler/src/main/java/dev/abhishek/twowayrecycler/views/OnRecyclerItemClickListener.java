package dev.abhishek.twowayrecycler.views;

import dev.abhishek.twowayrecycler.ItemVo;

/**
 * Created by abhishekpatil on 23/2/18.
 */

public interface OnRecyclerItemClickListener {
    void onItemClick(ItemVo content);
    void onItemLongClick(ItemVo content, int position);
    void onSeeAllPressed(ItemVo content);
}
