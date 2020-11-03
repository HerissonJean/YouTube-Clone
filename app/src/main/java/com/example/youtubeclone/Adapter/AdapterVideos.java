package com.example.youtubeclone.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeclone.Model.Videos;
import com.example.youtubeclone.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterVideos extends RecyclerView.Adapter<AdapterVideos.MyViewHolder> {

    private List<Videos> arrayVideos = new ArrayList<>();
    private Context cont ;

    public AdapterVideos (List<Videos> videos, Context cont){
        this.cont = cont;
        this.arrayVideos = videos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(cont).inflate(R.layout.adapter_videos,parent,false);
        return  new AdapterVideos.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Videos video = arrayVideos.get(position);
        holder.titulo.setText(video.getTitulo());

    }

    @Override
    public int getItemCount() {
        return arrayVideos.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView titulo;
        TextView descricao;
        TextView data;
        TextView capa;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.text_adapter_titulo);
            capa = itemView.findViewById(R.id.image_adapter_video);

        }
    }

}
