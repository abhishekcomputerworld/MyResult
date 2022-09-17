package com.board.exams.myresult.fication;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.board.exams.myresult.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private List<ListData>listData;
   public ImageView imageView;
    public MyAdapter(List<ListData> listData) {
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ficationoti,parent,false);
        imageView= view.findViewById(R.id.share);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ListData ld=listData.get(position);
        final String a=ld.getT();
        holder.txtname.setText(a);
        holder.txtmovie.setText(ld.getB());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a);
                stringBuilder2.append("\n\n");
                stringBuilder.append(stringBuilder2.toString());
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("\nTo check results download app: http://play.google.com/store/apps/details?id=");
                stringBuilder2.append(v.getContext().getApplicationContext().getPackageName());
                stringBuilder.append(stringBuilder2.toString());
                intent.putExtra("android.intent.extra.TEXT", stringBuilder.toString());
                intent.setType("text/plain");
                v.getContext().startActivity(Intent.createChooser(intent, "Forward news to your friends....."));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtname,txtmovie;
        public ViewHolder(View itemView) {
            super(itemView);
            txtname= itemView.findViewById(R.id.title);
            txtmovie= itemView.findViewById(R.id.subtitle);

        }
    }
}