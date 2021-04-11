package com.example.tugas3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private ArrayList<Integer> posterAnime = new ArrayList<Integer>();
    private ArrayList<String> judulAnime = new ArrayList<>();
    private ArrayList<String> genreAnime = new ArrayList<>();
    private ArrayList<String> sinopsisAnime = new ArrayList<>();
    private Context context;

    public RVAdapter(ArrayList<Integer> gambarPoster,
                     ArrayList<String> judulAnime,
                     ArrayList<String> genreAnime,
                     ArrayList<String> sinopsisAnime,
                     Context context) {
        this.posterAnime = gambarPoster;
        this.judulAnime = judulAnime;
        this.genreAnime = genreAnime;
        this.sinopsisAnime = sinopsisAnime;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).asBitmap().load(posterAnime.get(position)).into(holder.imageViewAnime);

        holder.textViewAnime.setText(judulAnime.get(position));
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("gambar_anime", posterAnime.get(position));
                intent.putExtra("nama_anime", judulAnime.get(position));
                intent.putExtra("anime_genre", genreAnime.get(position));
                intent.putExtra("detail_anime", sinopsisAnime.get(position));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return judulAnime.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imageViewAnime;
        TextView textViewAnime;
        ConstraintLayout constraintLayout;
        CardView kartu;
        LinearLayout jeroan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewAnime = itemView.findViewById(R.id.poster_anime);
            textViewAnime = itemView.findViewById(R.id.judul_anime);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
            kartu = itemView.findViewById(R.id.drafcard);
            jeroan = itemView.findViewById(R.id.dlmcard);

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daftar_anime, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
}
