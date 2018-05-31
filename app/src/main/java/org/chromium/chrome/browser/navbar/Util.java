package org.chromium.chrome.browser.navbar;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;


/**
 * Util class to help animate views
 */
public class Util {

    private static final int DURATION = 450;
    private static Animation animation;

    /**
     * Supposed to tell if the expandable view is animating or not
     */
    public static boolean isAnimating() {
        return (animation != null && (!animation.hasEnded()));
    }

    /**
     * Expands the view from 0 initial height till it's fully visible
     */
    public static void expand(final View view) {
        //Getting the proper height we want to set the view height to
        int matchParentMeasureSpec = View.MeasureSpec.makeMeasureSpec(((View) view.getParent()).getWidth(), View.MeasureSpec.EXACTLY);
        int wrapContentMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(matchParentMeasureSpec, wrapContentMeasureSpec);
        final int targetHeight = view.getMeasuredHeight();


        view.getLayoutParams().height = 0;
        view.setVisibility(View.VISIBLE);
        animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                view.getLayoutParams().height = (int) (targetHeight * interpolatedTime);
                view.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        animation.setDuration(DURATION);
        view.startAnimation(animation);
    }

    /**
     * Collapses the given view until it's completely gone -> Height =0
     * then sets it's visiblity to gone
     */
    public static void collapse(final View view) {
        final int initialHeight = view.getMeasuredHeight();

        animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    view.setVisibility(View.GONE);
                } else {
                    view.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    view.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };
        animation.setDuration(DURATION);
        view.startAnimation(animation);
    }
}
