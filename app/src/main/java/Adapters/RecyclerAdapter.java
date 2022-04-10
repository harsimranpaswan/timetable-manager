package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.workshop.ttm.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<ModelClass> taskList;
    public RecyclerAdapter(List<ModelClass>taskList){
        this.taskList=taskList;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        String title=taskList.get(position).getTitle();
        String description=taskList.get(position).getDescription();
        String time=taskList.get(position).getTime();

        holder.setItem(title,description,time);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titl;
        private TextView desc;
        private TextView tim;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titl=itemView.findViewById(R.id.tasktitle);
            desc=itemView.findViewById(R.id.taskdesc);
            tim=itemView.findViewById(R.id.tasktime);
        }

        public void setItem(String title, String description, String time) {
            titl.setText(title);
            desc.setText(description);
            tim.setText(time);
        }
    }
}
