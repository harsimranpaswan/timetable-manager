package Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.workshop.ttm.R;

import java.util.ArrayList;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.myViewHolder>{
    ArrayList <ModelClass> dataHolder;

    public NewAdapter(ArrayList<ModelClass> dataHolder) {
        this.dataHolder = dataHolder;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
    holder.title.setText(dataHolder.get(position).getTitle());
    holder.description.setText(dataHolder.get(position).getDescription());
    holder.time.setText(dataHolder.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView title,description,time;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            title= itemView.findViewById(R.id.tasktitle);
            description=itemView.findViewById(R.id.taskdesc);
            time=itemView.findViewById(R.id.tasktime);
        }
    }
}
