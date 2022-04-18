package com.workshop.ttm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.workshop.ttm.RoomDatabase.TaskDatabase;
import com.workshop.ttm.RoomDatabase.Task;
import com.workshop.ttm.RoomDatabase.TasksViewModel;

import java.util.List;

public class Tasks extends Fragment {
    RecyclerView tasksRecycler;
    TasksViewModel tasksViewModel;

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_tasks, container, false);
        tasksRecycler=rootView.findViewById(R.id.tasksRecycler);

         tasksViewModel = ViewModelProviders.of(this).get(TasksViewModel.class);
         tasksViewModel.getAllTasks().observe((LifecycleOwner) this.getContext(), new Observer<List<Task>>() {
             @Override
             public void onChanged(@Nullable List<Task> Tasks) {
                 //update RecyclerView
               Toast.makeText(getContext(), "onChanged", Toast.LENGTH_SHORT).show();
             }
         });
         return rootView;
    }
}