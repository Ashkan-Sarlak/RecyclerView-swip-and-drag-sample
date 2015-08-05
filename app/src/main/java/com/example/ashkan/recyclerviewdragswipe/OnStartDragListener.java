package com.example.ashkan.recyclerviewdragswipe;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Ashkan <ashkan.sarlak@gmail.com> on 7/27/15.
 */
public interface OnStartDragListener {
    /**
     * Called when a view is requesting a start of a drag.
     *
     * @param viewHolder The holder of the view to drag.
     */
    void onStartDrag(RecyclerView.ViewHolder viewHolder);
}
