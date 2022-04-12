package com.workshop.ttm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.workshop.ttm.Adapters.ModelClass;
import com.workshop.ttm.Adapters.NewAdapter;

public class Tasks extends Fragment {
    RecyclerView tasksRecycler;
    List<ModelClass>taskList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_tasks, container, false);
        tasksRecycler= rootView.findViewById(R.id.tasksRecycler);
        tasksRecycler.setLayoutManager(new LinearLayoutManager(getContext()));


        initData();
        initRecyclerView();

        return rootView;
    }

    private void initData() {
        taskList=new ArrayList<>();
        taskList.add(new ModelClass("CyberLabs Mid Evaluation","Attend the CyberLabs Mid Evaluation at SAC 112", "18:30"));
        taskList.add(new ModelClass("Wash Clothes","Some pants and shirts", "20:00"));
      // taskList.add(new ModelClass("CyberLabs Mid Evaluation","Attend the CyberLabs Mid Evaluation at SAC 112", "18:30"));

    }
    private void initRecyclerView(){
        tasksRecycler.setAdapter(new NewAdapter((ArrayList<ModelClass>) taskList));
    }

}