package org.chromium.chrome.browser.navbar.fragment;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


import org.chromium.base.metrics.RecordUserAction;
import org.chromium.chrome.R;
import org.chromium.chrome.browser.ChromeActivity;
import org.chromium.chrome.browser.download.DownloadUtils;
import org.chromium.chrome.browser.history.HistoryManagerUtils;
import org.chromium.chrome.browser.metrics.StartupMetrics;
import org.chromium.chrome.browser.navbar.adapter.ButtonAdapter;
import org.chromium.chrome.browser.ntp.NewTabPage;
import org.chromium.chrome.browser.ntp.NewTabPageUma;
import org.chromium.chrome.browser.preferences.PrefServiceBridge;
import org.chromium.chrome.browser.preferences.PreferencesLauncher;
import org.chromium.chrome.browser.tab.Tab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Fragment class to show gridview containing some buttons
 * it's supposed to be the first page in the ViewPager in the expandable navigation bar
 */
public class FirstPageFragment extends Fragment {
    ChromeActivity activity;

    public FirstPageFragment() {
    }

    @SuppressLint("ValidFragment")
    public FirstPageFragment(ChromeActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("InflateParams")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment_layout, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Buttons Labels
        List<String> buttonNames = new ArrayList<>(6);
        Collections.addAll(buttonNames
                , "New Tab"
                , "New Incognito"
                , "Settings"
                , "History"
                , "Downloads"
                , "Full Screen");

        //Buttons Icons
        List<Integer> buttonDrawables = new ArrayList<>(6);
        Collections.addAll(buttonDrawables
                , R.drawable.ic_plus
                , R.drawable.new_incognito_tab
                , R.drawable.ic_settings
                , R.drawable.ic_history
                , R.drawable.ic_downloads
                , R.drawable.ic_fullscreen);

        //GridView Instantiation
        GridView gridView = view.findViewById(R.id.mainGridView);
        gridView.setAdapter(new ButtonAdapter(this.getContext(), buttonNames, buttonDrawables , this));

    }

    public void itemClicked(int id)
    {
        switch (id) {
            case R.drawable.ic_plus:
                activity.getTabModelSelector().getModel(false).commitAllTabClosures();
                RecordUserAction.record("MobileMenuNewTab");
                RecordUserAction.record("MobileNewTabOpened");
                activity.getTabCreator(false).launchNTP();
                break;
            case R.drawable.new_incognito_tab:
                if (PrefServiceBridge.getInstance().isIncognitoModeEnabled()) {
                    activity.getTabModelSelector().getModel(false).commitAllTabClosures();
                    // This action must be recorded before opening the incognito tab since UMA actions
                    // are dropped when an incognito tab is open.
                    RecordUserAction.record("MobileMenuNewIncognitoTab");
                    RecordUserAction.record("MobileNewTabOpened");
                    activity.getTabCreator(true).launchNTP();
                }
                break;
            case R.drawable.ic_settings:
                PreferencesLauncher.launchSettingsPage(this.getContext(), null);
                RecordUserAction.record("MobileMenuSettings");
                break;
            case R.drawable.ic_history:
                RecordUserAction.record("MobileMenuHistory");
                HistoryManagerUtils.showHistoryManager(activity, null);
                StartupMetrics.getInstance().recordOpenedHistory();
                break;
            case R.drawable.ic_downloads:
                DownloadUtils.showDownloadManager(this.getActivity(), null);
                RecordUserAction.record("MobileMenuDownloadManager");
                break;
            default:
                break;
        }
        activity.expandableViewClicked();
    }
}
