package org.chromium.chrome.browser.navbar.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import org.chromium.chrome.browser.navbar.fragment.FirstPageFragment;

import java.util.List;

/**
 * GridView's adapter
 * which supposed to populate the GridView's children with Buttons
 */
public class ButtonAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> buttonNames;
    private List<Integer> buttonDrawables;
    private FirstPageFragment fragment;

    /**
     * Initializes the ButtonNames list and ButtonDrawables list
     */
    public ButtonAdapter(Context c, List<String> buttonNames, @DrawableRes List<Integer> buttonDrawables, FirstPageFragment fragment) {
        mContext = c;
        this.buttonDrawables = buttonDrawables;
        this.buttonNames = buttonNames;
        this.fragment = fragment;
    }

    public int getCount() {
        return buttonNames.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return buttonDrawables.get(position);
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        Button button;
        // if it's not recycled, initialize some attributes
        if (convertView == null) {
            //Styling the buttons
            button = new Button(mContext, null, android.R.attr.borderlessButtonStyle);
            button.setText(buttonNames.get(position));
            button.setTextSize(12);
            button.setTextColor(Color.parseColor("#999999"));
            button.setFocusable(false);
            button.setFocusableInTouchMode(false);
            button.setOnClickListener(v -> {
                if (fragment != null)
                    fragment.itemClicked(buttonDrawables.get(position));
            });
        } else {
            button = (Button) convertView;
        }
        button.setCompoundDrawablesWithIntrinsicBounds(null, mContext.getResources().getDrawable(buttonDrawables.get(position), null), null, null);
        return button;
    }
}
