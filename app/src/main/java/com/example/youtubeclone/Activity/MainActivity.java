 package com.example.youtubeclone.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeclone.Adapter.AdapterVideos;
import com.example.youtubeclone.Model.Videos;
import com.example.youtubeclone.R;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToLongBiFunction;

 public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Videos> arrayVideos = new ArrayList<>();
    private AdapterVideos AdapterVideos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =  findViewById(R.id.toolbar);

        recyclerView = findViewById(R.id.recyclerVideos);
        recuperarVideos();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterVideos = new AdapterVideos(arrayVideos,MainActivity.this);
        recyclerView.setAdapter(AdapterVideos);


    }
    private void recuperarVideos(){

        Videos videos1 = new Videos();
        videos1.setTitulo("Video 1");
        arrayVideos.add(videos1);

        Videos videos2 = new Videos();
        videos2.setTitulo("Video 2");
        arrayVideos.add(videos2);

    }
}