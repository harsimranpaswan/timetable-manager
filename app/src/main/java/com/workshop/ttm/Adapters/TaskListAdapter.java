package com.workshop.ttm.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.api.Context;
import com.workshop.ttm.NewRoomDB.TaskDB;
import com.workshop.ttm.R;

import java.util.List;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.MyViewHolder> {

    private Context context;
    private List<TaskDB> taskDBList;
    public TaskListAdapter(Context context){this.context=context;}


    public void setTaskDBList(List<TaskDB> taskDBList){
        this.taskDBList=taskDBList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TaskListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskListAdapter.MyViewHolder holder, int position) {
        holder.tasktitle.setText(this.taskDBList.get(position).title);
        holder.taskdesc.setText(this.taskDBList.get(position).task_desc);
    }


    @Override
    public int getItemCount() {
        return this.taskDBList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tasktitle;
        TextView taskdesc;
        public MyViewHolder(View view){
            super(view);
            tasktitle=view.findViewById(R.id.tasktitle);
            taskdesc=view.findViewById(R.id.taskdesc);
        }
    }
}
