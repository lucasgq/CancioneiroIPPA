package br.com.ippontadareia.cancioneiroippa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.ippontadareia.cancioneiroippa.dao.CanticoDAO;
import br.com.ippontadareia.cancioneiroippa.dao.TamanhoFonteDAO;
import br.com.ippontadareia.cancioneiroippa.helper.Constants;
import br.com.ippontadareia.cancioneiroippa.helper.SongbookHelper;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;
import br.com.ippontadareia.cancioneiroippa.modelo.TamanhoFonte;

public class LyricsActivity extends AppCompatActivity {

    private SongbookHelper helper;
    private Cantico cantico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);

        Toolbar toolbar = (Toolbar) findViewById(R.id.child_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.home);
        ab.setDisplayShowTitleEnabled(false);

        helper = new SongbookHelper(this, LyricsActivity.this);

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
        inflater.inflate(R.menu.toolbar, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_search:

                Intent intentGoToSearchPopUp = new Intent(LyricsActivity.this, SearchSongActivity.class);
                startActivity(intentGoToSearchPopUp);

                break;

            case R.id.action_favorite:

                CanticoDAO dao = new CanticoDAO(LyricsActivity.this);
                List<Cantico> listCanticos = new ArrayList<Cantico>();
                listCanticos = dao.listFavorites();
                Intent intentGoToFavoriteList = new Intent(LyricsActivity.this, FavoritesActivity.class);
                intentGoToFavoriteList.putExtra("favoriteList", (ArrayList<Cantico>) listCanticos);
                startActivity(intentGoToFavoriteList);

                break;

            case R.id.action_settings:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                LayoutInflater inflater = this.getLayoutInflater();
                View view = inflater.inflate(R.layout.settings_activity, null);

                builder.setView(view)
                        .setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int id) {
                            }
                        });

                final TamanhoFonteDAO fontDAO = new TamanhoFonteDAO(this);

                SeekBar fontSizeSB = (SeekBar) view.findViewById(R.id.seekbar_font_size);
                final TextView fontSizeIndicator = (TextView) view.findViewById(R.id.font_size_selected);
                TamanhoFonte tf = fontDAO.selectSizes();
                fontSizeIndicator.setText(tf.getLyricSize().toString());

                fontSizeSB.setProgress((int) (tf.getLyricSize() - Constants.MIN_FONT_SIZE));

                fontSizeSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        fontSizeIndicator.setText(progress + Constants.MIN_FONT_SIZE + "");
                        fontDAO.changeFontsize(progress + Constants.MIN_FONT_SIZE);
                        //TODO HOW TO UPDATE LYRICS? CREATE ADAPTER?
                        helper.fillScreen(cantico);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

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
        cantico = dao.selectSongByNumber(cantico.getNumber());
        helper.fillScreen(cantico);
    }
}
