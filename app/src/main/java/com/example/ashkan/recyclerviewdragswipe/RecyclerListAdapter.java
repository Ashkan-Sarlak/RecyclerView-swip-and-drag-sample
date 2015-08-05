package com.example.ashkan.recyclerviewdragswipe; /**
 * Created by ashkan on 7/4/15.
 */
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecyclerListAdapter extends RecyclerView.Adapter<ItemViewHolder> implements ItemTouchHelperAdapter {

    private static final String[] STRINGS = new String[]{
            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"
    };

    private final OnStartDragListener mDragStartListener;

    private final List<String> mItems = new ArrayList<>();

    public RecyclerListAdapter(OnStartDragListener dragStartListener) {
        mDragStartListener = dragStartListener;
        mItems.addAll(Arrays.asList(STRINGS));
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        holder.textView.setText(mItems.get(position));

        holder.handleView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) ==
                        MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }
}