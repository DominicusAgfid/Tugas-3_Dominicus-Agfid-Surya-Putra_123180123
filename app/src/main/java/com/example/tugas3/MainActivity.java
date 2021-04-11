package com.example.tugas3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Integer> posterAnime = new ArrayList<Integer>();
    private ArrayList<String> judulAnime = new ArrayList<>();
    private ArrayList<String> genreAnime = new ArrayList<>();
    private ArrayList<String> sinopsisAnime = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDataGame();
    }
    private void getDataGame(){
        judulAnime.add("Fullmetal Alchemist");
        posterAnime.add(R.drawable.fab);
        genreAnime.add("Action, Military, Adventure, Comedy, Drama, Magic, Fantasy, Shounen");
        sinopsisAnime.add("Alchemy is bound by this Law of Equivalent Exchange—something the young brothers Edward and Alphonse Elric only realize after attempting human transmutation: the one forbidden act of alchemy. They pay a terrible price for their transgression—Edward loses his left leg, Alphonse his physical body. It is only by the desperate sacrifice of Edward's right arm that he is able to affix Alphonse's soul to a suit of armor. Devastated and alone, it is the hope that they would both eventually return to their orig");

        judulAnime.add("Jujutsu Kaisen");
        posterAnime.add(R.drawable.jjk);
        genreAnime.add("Action, Demons, Supernatural, School, Shounen");
        sinopsisAnime.add("Idly indulging in baseless paranormal activities with the Occult Club, high schooler Yuuji Itadori spends his days at either the clubroom or the hospital, where he visits his bedridden grandfather. However, this leisurely lifestyle soon takes a turn for the strange when he unknowingly encounters a cursed item. Triggering a chain of supernatural occurrences, Yuuji finds himself suddenly thrust into the world of Curses—dreadful beings formed from human malice and negativity—after swallowing the said item, revealed to be a finger belonging to the demon Sukuna Ryoumen, the King of Curses.");

        judulAnime.add("Natsume Yuujinchou");
        posterAnime.add(R.drawable.nny);
        genreAnime.add("Slice of Life, Demons, Supernatural, Drama, Shoujo");
        sinopsisAnime.add("While most fifteen-year-old boys, in one way or another, harbor secrets that are related to girls, Takashi Natsume has a peculiar and terrifying secret involving youkai: for as long as he can remember, he has been constantly chased by these spirits. Natsume soon discovers that his deceased grandmother Reiko had passed on to him the Yuujinchou, or \"Book of Friends,\" which contains the names of the spirits whom she brought under her control. Now in Natsume's possession, the book gives Reiko's grandson this power as well, which is why these enraged beings now haunt him in hopes of somehow attaining their freedom.");

        judulAnime.add("Shingeki no Kyojin");
        posterAnime.add(R.drawable.snk);
        genreAnime.add("Action, Military, Mystery, Super Power, Drama, Fantasy, Shounen");
        sinopsisAnime.add("Gabi Braun and Falco Grice have been training their entire lives to inherit one of the seven titans under Marley's control and aid their nation in eradicating the Eldians on Paradis. However, just as all seems well for the two cadets, their peace is suddenly shaken by the arrival of Eren Yeager and the remaining members of the Survey Corps.");
        processRecyclerViewAdapter();
    }
    private void processRecyclerViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.anime);
        RVAdapter adapter = new RVAdapter(posterAnime, judulAnime, genreAnime, sinopsisAnime,this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}