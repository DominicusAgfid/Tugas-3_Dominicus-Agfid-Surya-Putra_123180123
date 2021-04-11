package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    ImageView ivLogo;
    TextView tvDetail,tvNama, tvGenre;

    private void getIncomingExtra(){
        if(getIntent().hasExtra("gambar_anime") && getIntent().hasExtra("nama_anime") && getIntent().hasExtra("anime_genre")){
            Integer gambarPoster = getIntent().getIntExtra("gambar_anime",0);
            String judulAnime = getIntent().getStringExtra("nama_anime");
            String genreAnime = getIntent().getStringExtra("anime_genre");
            String sinopsisAnime = getIntent().getStringExtra("detail_anime");

            setDataActivity(gambarPoster, judulAnime, genreAnime, sinopsisAnime);
        }
    }

    private void setDataActivity(Integer image, String nama, String genre, String detail){
        Glide.with(this).asBitmap().load(image).into(ivLogo);

        tvNama.setText(nama);
        tvGenre.setText(genre);
        tvDetail.setText(detail);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivLogo = findViewById(R.id.poster_anime);
        tvNama = findViewById(R.id.judul_anime);
        tvGenre = findViewById(R.id.genre_anime);
        tvDetail = findViewById(R.id.sinopsis_anime);

        getIncomingExtra();
    }
}