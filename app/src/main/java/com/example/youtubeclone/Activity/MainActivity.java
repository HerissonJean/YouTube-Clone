 package com.example.youtubeclone.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeclone.Adapter.AdapterVideos;
import com.example.youtubeclone.Api.YoutubeServices;
import com.example.youtubeclone.Model.Resultado;
import com.example.youtubeclone.Model.Videos;
import com.example.youtubeclone.R;
import com.example.youtubeclone.helper.RetrofitSetup;
import com.example.youtubeclone.helper.YouTubeSetup;
import com.miguelcatalan.materialsearchview.MaterialSearchView;


import java.util.ArrayList;
import java.util.List;
import java.util.function.ToLongBiFunction;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

 public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Videos> arrayVideos = new ArrayList<>();
    private AdapterVideos AdapterVideos;
    private MaterialSearchView searchView;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =  findViewById(R.id.toolbar);


        recyclerView = findViewById(R.id.recyclerVideos);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AdapterVideos = new AdapterVideos(arrayVideos,MainActivity.this);
        recyclerView.setAdapter(AdapterVideos);

//        searchView = findViewById(R.id.searchView_toolbar_pesquisa);

        retrofit = RetrofitSetup.getRetrofit();

        recuperarVideos();

    }
    private void recuperarVideos(){

        YoutubeServices youtubeServices = retrofit.create( YoutubeServices.class );

        youtubeServices.recuperarVideos(
            "snnipet","date","20", YouTubeSetup.CHAVE_YOUTUBE_API,YouTubeSetup.CANAL_ID
        ).enqueue(new Callback<Resultado>() {
            @Override
            public void onResponse(Call<Resultado> call, Response<Resultado> response) {
                Log.d("teste", "teste0: "+response.toString());
                if(response.isSuccessful()){
                Resultado resultado = response.body();
               TextView texto =  findViewById(R.id.testo1);
               texto.setText(response.body().toString());

               TextView texto2 =  findViewById(R.id.testo2);
               texto2.setText(response.toString());

                }
            }

            @Override
            public void onFailure(Call<Resultado> call, Throwable t) {
                Log.d("teste", "teste1: "+t.toString());
                TextView texto =  findViewById(R.id.testo1);
                texto.setText(t.toString());

            }
        });

    }
}