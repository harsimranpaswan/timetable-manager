package com.workshop.ttm.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.Task;
import com.workshop.ttm.R;

import java.util.ArrayList;
import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskHolder> {
    private List<Task> tasks = new ArrayList<>();

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);
        return new TaskHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        holder.tasktitle.setText(tasks.get(position).getTitle);
        holder.taskdesc.setText(tasks.get(position).getDesc);
      //  holder.textViewPriority.setText(String.valueOf(currentTask.getPriority()));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(List<Task> Task) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    class TaskHolder extends RecyclerView.ViewHolder {
        private TextView tasktitle;
        private TextView taskdesc;
      //  private TextView textViewPriority;

        public TaskHolder(View itemView) {
            super(itemView);
            tasktitle = itemView.findViewById(R.id.tasktitle);
            taskdesc = itemView.findViewById(R.id.taskdesc);
    //        textViewPriority = itemView.findViewById(R.id.text_view_priority);
        }
    }
}

