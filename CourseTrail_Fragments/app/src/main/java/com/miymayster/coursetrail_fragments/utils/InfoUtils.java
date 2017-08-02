package com.miymayster.coursetrail_fragments.utils;

import java.util.ArrayList;

/**
 * Created by Olga on 02.08.2017.
 */

public class InfoUtils {
    private static ArrayList<String> mMasterFlowList;
    private static ArrayList<String> mInfoList;
    private static final int LENGTH = 7;

    public static ArrayList<String> getMasterFlowList() {
        if (mMasterFlowList == null) {
            mMasterFlowList = new ArrayList<>();
            for (int i = 1; i <= LENGTH; i++) {
                mMasterFlowList.add("item " + i);
            }
        }
        return mMasterFlowList;
    }

    public static ArrayList<String> getInfoList() {
        if (mInfoList == null) {
            mInfoList = new ArrayList<>();
            for (int i = 1; i <= LENGTH; i++) {
                mInfoList.add("info about item " + i);
            }
        }
        return mInfoList;
    }

    public static void clearMasterFlowList() {
        mMasterFlowList.clear();
        mMasterFlowList = null;
    }

    public static void clearInfoList() {
        mInfoList.clear();
        mInfoList = null;
    }
}
