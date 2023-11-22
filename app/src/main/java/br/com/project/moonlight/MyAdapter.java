package br.com.project.moonlight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import br.com.project.moonlight.database.DataClass;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<DataClass> dataList;
    private Context context;

    public MyAdapter(Context context, ArrayList<DataClass> dataList) {

        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(dataList.get(position).getImageURL()).into(holder.recyclerImage);
        holder.recyclerCaption.setText(dataList.get(position).getCaption());
        holder.uploadDescription.setText(dataList.get(position).getDescription());
        holder.uploadValue.setText("R$ "+dataList.get(position).getValue());
        holder.uploadDate.setText(dataList.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView recyclerImage;
        TextView recyclerCaption;

        TextView uploadDescription;
        TextView uploadValue;
        TextView uploadDate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerImage = itemView.findViewById(R.id.uploadImage);
            recyclerCaption = itemView.findViewById(R.id.uploadCaption);
            uploadDescription = itemView.findViewById(R.id.uploadDescription);
            uploadValue = itemView.findViewById(R.id.uploadValue);
            uploadDate = itemView.findViewById(R.id.uploadDate);
        }
    }
}