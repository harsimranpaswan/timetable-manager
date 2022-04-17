package com.workshop.ttm;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import com.google.api.Context;
import com.workshop.ttm.Adapters.ModelClass;
import com.workshop.ttm.Adapters.NewAdapter;
import com.workshop.ttm.Adapters.TaskListAdapter;
import com.workshop.ttm.NewRoomDB.AppDB;
import com.workshop.ttm.NewRoomDB.TaskDB;
import com.workshop.ttm.NewRoomDB.TaskDao;

public class Tasks extends Fragment {
    RecyclerView tasksRecycler;
    private TaskListAdapter taskListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_tasks, container, false);
        tasksRecycler=rootView.findViewById(R.id.tasksRecycler);
        tasksRecycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        taskListAdapter=new TaskListAdapter();
        tasksRecycler.setAdapter(taskListAdapter);
        LoadTaskList();
        return rootView;

    }

    private void LoadTaskList(){
        AppDB db= AppDB.getDbInstance(this.getContext());
        List<TaskDB> taskDBList=db.taskDao.getAllTasks();
        taskListAdapter.setTaskDBList(taskDBList);
    }
    /*
    private void initData() {
        taskList=new ArrayList<>();
        taskList.add(new ModelClass("CyberLabs Mid Evaluation","Attend the CyberLabs Mid Evaluation at SAC 112", "18:30"));
        taskList.add(new ModelClass("Wash Clothes","Some pants and shirts", "20:00"));
      // taskList.add(new ModelClass("CyberLabs Mid Evaluation","Attend the CyberLabs Mid Evaluation at SAC 112", "18:30"));
    }

*/
}