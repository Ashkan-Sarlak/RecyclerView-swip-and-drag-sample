package com.example.ashkan.recyclerviewdragswipe;

/**
 * Created by ashkan on 7/4/15.
 */
public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}