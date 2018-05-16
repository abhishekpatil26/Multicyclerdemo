package dev.abhishek.twowayrecycler;

/**
 * Created by abhishekpatil on 6/3/18.
 */

public interface OnContentListUpdateListener {

    void onContentListChanged();
    void onContentListItemChanged(int position);
    void onContentListItemRangeChanged(int positionStart, int itemCount);

}
