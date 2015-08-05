package com.example.ashkan.recyclerviewdragswipe;

/**
 * Created by Ashkan <ashkan.sarlak@gmail.com> on 7/27/15.
 */

import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Notifies a View Holder of relevant callbacks from
 * {@link ItemTouchHelper.Callback}.
 */
public interface ItemTouchHelperViewHolder {

    /**
     * Called when the {@link ItemTouchHelper} first registers an
     * item as being moved or swiped.
     * Implementations should update the item view to indicate
     * it's active state.
     */
    void onItemSelected();


    /**
     * Called when the {@link ItemTouchHelper} has completed the
     * move or swipe, and the active item state should be cleared.
     */
    void onItemClear();
}