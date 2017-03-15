package br.com.ippontadareia.cancioneiroippa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ippontadareia.cancioneiroippa.dao.CanticoDAO;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;

public class LyricsActivity extends AppCompatActivity {

    private SongbookHelper helper;
    private Cantico cantico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.home);

        helper = new SongbookHelper(this);

        Intent intent = getIntent();
        cantico = (Cantico) intent.getSerializableExtra("cantico");

        if (cantico != null) {
            helper.fillScreen(cantico);
        }

        ImageView favoriteSong = (ImageView) findViewById(R.id.cantico_favorite);
        favoriteSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFavoriteSong();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_button, menu);
        inflater.inflate(R.menu.favorite_list_button, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.search_song:

                Intent intentGoToSearchPopUp = new Intent(LyricsActivity.this, SearchPopUpActivity.class);
                startActivity(intentGoToSearchPopUp);

                break;

            case R.id.favorite_list:

                CanticoDAO dao = new CanticoDAO(LyricsActivity.this);
                List<Cantico> listCanticos = new ArrayList<Cantico>();
                listCanticos = dao.listFavorites();
                Intent intentGoToFavoriteList = new Intent(LyricsActivity.this, SummaryActivity.class);
                intentGoToFavoriteList.putExtra("favoriteList", (ArrayList<Cantico>) listCanticos);

                if(listCanticos.size() == 0){
                    Toast.makeText(LyricsActivity.this, "Não há cânticos na lista de favoritos", Toast.LENGTH_SHORT).show();
                }
                startActivity(intentGoToFavoriteList);

                break;

            case R.drawable.home:
                Intent intentGoHome = new Intent(this, SummaryActivity.class);
                startActivity(intentGoHome);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setFavoriteSong(){
        CanticoDAO dao = new CanticoDAO(this);
        cantico = dao.setFavorite(cantico);
        Intent intentGoToLyrics = new Intent(LyricsActivity.this, LyricsActivity.class);
        intentGoToLyrics.putExtra("cantico", cantico);
        helper.fillScreen(cantico);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadLyrics();
    }

    private void loadLyrics() {
        CanticoDAO dao = new CanticoDAO(LyricsActivity.this);
        cantico = dao.selectByNumber(cantico.getNumber());
        helper.fillScreen(cantico);
    }
}
