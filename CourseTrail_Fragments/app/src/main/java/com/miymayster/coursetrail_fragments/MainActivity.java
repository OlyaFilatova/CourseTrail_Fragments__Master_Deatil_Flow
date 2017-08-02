package com.miymayster.coursetrail_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.miymayster.coursetrail_fragments.utils.InfoUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MasterFragment.OnMasterFlowClickListener {

    private ArrayList<String> mInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInfoList = InfoUtils.getInfoList();


    }

    @Override
    public void onMasterFlowClick(int position) {
        if (findViewById(R.id.info_receiver_fragment) != null) {
            InfoFragment infoFragment = new InfoFragment();
            infoFragment.setInfoText(mInfoList.get(position));
            getSupportFragmentManager().beginTransaction().replace(R.id.info_receiver_fragment, infoFragment).addToBackStack(null).commit();
        } else {
            Intent intent = new Intent(this, InfoActivity.class);
            intent.putExtra(InfoActivity.KEY_POSITION, position);
            startActivity(intent);
        }
    }
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

}
