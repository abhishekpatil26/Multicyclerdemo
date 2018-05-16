package dev.abhishek.twowayrecycler;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by abhishekpatil on 6/3/18.
 */

public class ContentList<E> extends ArrayList<E> {

    private OnContentListUpdateListener onContentListUpdateListener;

    public void setOnContentListUpdateListener(OnContentListUpdateListener onContentListUpdateListener) {
        this.onContentListUpdateListener = onContentListUpdateListener;
    }

    private void notifyListChanged(){
        if(onContentListUpdateListener != null) onContentListUpdateListener.onContentListChanged();
    }

    private void notifyListItemChanged(int position){
        if(onContentListUpdateListener != null)
            onContentListUpdateListener.onContentListItemChanged(position);
    }

    private void notifyListItemRangeChanged(int positionStart, int itemCount){
        if(onContentListUpdateListener != null)
            onContentListUpdateListener.onContentListItemRangeChanged(positionStart, itemCount);
    }

    @Override
    public boolean add(E object) {
        boolean b = super.add(object);
        notifyListChanged();
        return b;
    }

    @Override
    public void add(int index, E object) {
        super.add(index, object);
        notifyListItemChanged(index);
    }

    @Override
    public boolean addAll(Collection collection) {
        boolean b = super.addAll(collection);
        notifyListChanged();
        return b;
    }

    @Override
    public boolean addAll(int index, Collection collection) {
        boolean b = super.addAll(index, collection);
        notifyListChanged();
        return b;
    }

    @Override
    public boolean remove(Object object) {
        boolean b = super.remove(object);
        notifyListChanged();
        return b;
    }

    @Override
    public E remove(int index) {
        E b = super.remove(index);
        notifyListItemChanged(index);
        return b;
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex);
        notifyListChanged();
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean b = super.removeAll(collection);
        notifyListChanged();
        return b;
    }

    @Override
    public void clear() {
        super.clear();
        notifyListChanged();
    }
}
