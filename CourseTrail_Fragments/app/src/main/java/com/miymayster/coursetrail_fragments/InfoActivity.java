package com.miymayster.coursetrail_fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.miymayster.coursetrail_fragments.utils.InfoUtils;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    private ArrayList<String> mInfoList;
    TextView mInfoTextView;
    public static final String KEY_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        if (getIntent() == null || getIntent().getIntExtra(KEY_POSITION, -1) == -1) {
            finish();
        }

        int position = getIntent().getIntExtra(KEY_POSITION, -1);
        mInfoTextView = (TextView) findViewById(R.id.info_text_view);
        mInfoList = InfoUtils.getInfoList();
        //mInfoTextView.setText(mInfoList.get(position));
        InfoFragment fragment = (InfoFragment) getSupportFragmentManager().findFragmentById(R.id.info);
        fragment.setInfoText(mInfoList.get(position));
    }
}
