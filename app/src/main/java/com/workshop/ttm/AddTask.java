package com.workshop.ttm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.workshop.ttm.RoomDatabase.TaskDatabase;
import com.workshop.ttm.RoomDatabase.Task;

import androidx.fragment.app.Fragment;

public class AddTask extends Fragment {
    Button addTask;
    EditText addTitle;
    EditText addDescription;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View addview= inflater.inflate(R.layout.fragment_addtask, container, false);
        addTask=addview.findViewById(R.id.addTask);
        addTitle=addview.findViewById(R.id.addTitle);
        addDescription=addview.findViewById(R.id.addDescription);

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newTask(addTask.getText().toString(),addDescription.getText().toString());
            }
        });
        return addview;
    }
    private void newTask(String title, String task_desc) {
        TaskDatabase db = TaskDatabase.getDbInstance(this.getContext());
        Task task = new Task();
        task.title = title;
        task.task_desc = task_desc;
        db.taskDao().insertTask();
        Toast.makeText(this.getContext(), "Task is added successfully", Toast.LENGTH_SHORT).show();
    }
}