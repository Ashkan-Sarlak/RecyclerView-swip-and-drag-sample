package com.example.ashkan.recyclerviewdragswipe; /**
 * Created by ashkan on 7/4/15.
 */
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

    public final TextView textView;
    public final ImageView handleView;

    private final ValueAnimator colorAnimation;

    public ItemViewHolder(final View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.text);
        handleView = (ImageView) itemView.findViewById(R.id.handle);

        colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), Color.WHITE, Color.CYAN);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                itemView.setBackgroundColor((Integer)animator.getAnimatedValue());
            }

        });
    }

    @Override
    public void onItemSelected() {
        colorAnimation.start();
    }

    @Override
    public void onItemClear() {
        colorAnimation.reverse();
    }

}