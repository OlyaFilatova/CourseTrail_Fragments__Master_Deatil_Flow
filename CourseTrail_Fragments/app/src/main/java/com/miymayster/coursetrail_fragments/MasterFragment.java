package com.miymayster.coursetrail_fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.miymayster.coursetrail_fragments.utils.InfoUtils;

import java.util.ArrayList;

/**
 * Created by Olga on 02.08.2017.
 */

public class MasterFragment extends Fragment {
    OnMasterFlowClickListener mListener;

    ArrayList<String> mOptions;

    public interface OnMasterFlowClickListener {
        public void onMasterFlowClick(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(context instanceof OnMasterFlowClickListener)) {
            throw new ClassCastException(context.toString() + " Must implement OnMasterFlowClickListener");
        }
        mListener = (OnMasterFlowClickListener) context;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.master_fragment, container, false);

        mOptions = InfoUtils.getMasterFlowList();


        ListView optionsList = (ListView) root.findViewById(R.id.options_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.master_item, mOptions);
        optionsList.setAdapter(adapter);
        optionsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mListener.onMasterFlowClick(i);
            }
        });

        return root;
    }
}
