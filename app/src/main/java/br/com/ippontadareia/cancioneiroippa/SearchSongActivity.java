package br.com.ippontadareia.cancioneiroippa;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ippontadareia.cancioneiroippa.dao.CanticoDAO;
import br.com.ippontadareia.cancioneiroippa.dao.TamanhoFonteDAO;
import br.com.ippontadareia.cancioneiroippa.helper.Constants;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;
import br.com.ippontadareia.cancioneiroippa.modelo.TamanhoFonte;

import static java.security.AccessController.getContext;

public class SearchSongActivity extends AppCompatActivity {

    private Constants constants;
    private TextView searchArgument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_song);

        Toolbar toolbar = (Toolbar) findViewById(R.id.search_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeAsUpIndicator(R.drawable.home);
        ab.setDisplayShowTitleEnabled(false);

        searchArgument = (TextView) findViewById(R.id.search_value);

        TamanhoFonteDAO fontDAO = new TamanhoFonteDAO(SearchSongActivity.this);
        TamanhoFonte sizes = fontDAO.selectSizes();

        searchArgument.setTextSize(sizes.getLyricSize());

        EditText songParameter = (EditText) findViewById(R.id.search_value);
        songParameter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int count, int after) {
                FragmentManager manager = getSupportFragmentManager();

                String argument = searchArgument.getText().toString().trim();

                Cantico cantico = new Cantico();
                List<Cantico> numberSearchList = new ArrayList<Cantico>();
                List<Cantico> titleSearchList = new ArrayList<Cantico>();
                List<Cantico> lyricSearchList = new ArrayList<Cantico>();

                CanticoDAO dao = new CanticoDAO(SearchSongActivity.this);
                String argumentToNumber = searchArgument.getText().toString().trim();

                FragmentTransaction tx = manager.beginTransaction();

                if(isNumeric(argumentToNumber)){
                    Long number = Long.valueOf(argumentToNumber);
                    numberSearchList = dao.selectByNumber(number);
                }
                doNumberFragmentTransaction(tx, numberSearchList);

                cantico.setTitle(argument);
                titleSearchList = dao.selectByTitle(cantico.getTitle());

                cantico.setLyrics(argument);
                lyricSearchList = dao.selectByLyrics(cantico.getLyrics());

                doTitleFragmentTransaction(tx, titleSearchList);
                doLyricsFragmentTransaction(tx, lyricSearchList);
                tx.commit();

                if((numberSearchList != null && numberSearchList.size() == 0)
                        &&(titleSearchList != null && titleSearchList.size() == 0)
                        &&(lyricSearchList != null && lyricSearchList.size() == 0)
                        && !argument.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Sem rsultados para '" + argument +"'", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void doNumberFragmentTransaction(FragmentTransaction tx, List<Cantico> numberSearchList) {
        Bundle numberParams = new Bundle();
        numberParams.putSerializable("numberList", (ArrayList<Cantico>)numberSearchList);

        SearchResultFragment numberListFragment = new SearchResultFragment();
        numberListFragment.setArguments(numberParams);

        tx.replace(R.id.number_list_song_frame, numberListFragment);
    }

    private void doTitleFragmentTransaction(FragmentTransaction tx, List<Cantico> titleSearchList) {
        Bundle titleParams = new Bundle();
        titleParams.putSerializable("titleList", (ArrayList<Cantico>)titleSearchList);

        SearchResultTitleFragment titleListFragment = new SearchResultTitleFragment();
        titleListFragment.setArguments(titleParams);

        tx.replace(R.id.title_list_song_frame, titleListFragment);
    }

    private void doLyricsFragmentTransaction(FragmentTransaction tx, List<Cantico> lyricSearchList) {
        Bundle lyricsParams = new Bundle();
        lyricsParams.putSerializable("lyrcList", (ArrayList<Cantico>)lyricSearchList);

        SearchResultLyricsFragment lyricsListFragment = new SearchResultLyricsFragment();
        lyricsListFragment.setArguments(lyricsParams);

        tx.replace(R.id.lyrics_list_song_frame, lyricsListFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        MenuItem item = menu.findItem(R.id.action_settings);
        item.setVisible(false);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_favorite:

                CanticoDAO dao = new CanticoDAO(SearchSongActivity.this);
                List<Cantico> listCanticos = new ArrayList<Cantico>();
                listCanticos = dao.listFavorites();
                Intent intentGoToFavoriteList = new Intent(SearchSongActivity.this, FavoritesActivity.class);
                intentGoToFavoriteList.putExtra("favoriteList", (ArrayList<Cantico>) listCanticos);
                startActivity(intentGoToFavoriteList);

                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private boolean isNumeric(String number){
        if(number.matches("\\d+(?:\\.\\d+)?")){
            return true;
        } else {
            return false;
        }
    }
}
