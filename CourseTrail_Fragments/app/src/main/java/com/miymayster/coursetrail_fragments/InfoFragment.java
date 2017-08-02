package com.miymayster.coursetrail_fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Olga on 02.08.2017.
 */

public class InfoFragment extends Fragment {
    TextView infoTextView;
    public static final String KEY_INFO = "info";
    private String mInfo = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.info_fragment, container, false);
        if (savedInstanceState != null) {
            mInfo = savedInstanceState.getString(KEY_INFO, "");
        }

        infoTextView = (TextView) root.findViewById(R.id.info_text_view);
        infoTextView.setText(mInfo);

        return root;
    }

    public void setInfoText(String info) {
        mInfo = info;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_INFO, mInfo);
    }
}
