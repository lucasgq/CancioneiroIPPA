package br.com.ippontadareia.cancioneiroippa;

import android.content.Intent;
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
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.ippontadareia.cancioneiroippa.adapter.ExpandableListAdapter;
import br.com.ippontadareia.cancioneiroippa.dao.CanticoDAO;
import br.com.ippontadareia.cancioneiroippa.dao.TamanhoFonteDAO;
import br.com.ippontadareia.cancioneiroippa.helper.Constants;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;
import br.com.ippontadareia.cancioneiroippa.modelo.TamanhoFonte;

public class SearchSongActivity extends AppCompatActivity {

    private Constants constants;
    private TextView searchArgument;
    private ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listHeader;
    HashMap<String, List<Cantico>> resultListChild;


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
                //FragmentManager manager = getSupportFragmentManager();

                String argument = searchArgument.getText().toString().trim();
                Bundle params = new Bundle();
                params.putSerializable("argument", argument);

                Cantico cantico = new Cantico();
                List<Cantico> numberSearchList = new ArrayList<>();
                List<Cantico> titleSearchList = new ArrayList<>();
                List<Cantico> lyricSearchList = new ArrayList<>();

                CanticoDAO dao = new CanticoDAO(SearchSongActivity.this);
                String argumentToNumber = searchArgument.getText().toString().trim();

                if(isNumeric(argumentToNumber)){
                    Long number = Long.valueOf(argumentToNumber);
                    numberSearchList = dao.selectByNumber(number);
                }

                cantico.setTitle(argument);
                titleSearchList = dao.selectByTitle(cantico.getTitle());

                cantico.setLyrics(argument);
                lyricSearchList = dao.selectByLyrics(cantico.getLyrics());

                expListView = (ExpandableListView) findViewById(R.id.expandable_complete_list);

                prepareResultList(numberSearchList, titleSearchList, lyricSearchList);

                listAdapter = new ExpandableListAdapter(getBaseContext(), listHeader, resultListChild, argument);

                expListView.setAdapter(listAdapter);

                expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id) {
                        Cantico cantico = (Cantico) listAdapter.getChild(groupPosition, childPosition);

                        Intent intentGoToLyrics = new Intent(getBaseContext(), LyricsActivity.class);
                        intentGoToLyrics.putExtra("cantico", cantico);
                        startActivity(intentGoToLyrics);

                        return true;
                    }
                });

                for(int i = 0; i < listHeader.size(); i++){
                    expListView.expandGroup(i);
                }

                if((numberSearchList != null && numberSearchList.size() == 0)
                        &&(titleSearchList != null && titleSearchList.size() == 0)
                        &&(lyricSearchList != null && lyricSearchList.size() == 0)
                        && !argument.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Sem resultados para '" + argument +"'", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    private void prepareResultList(List<Cantico> numberSearchList, List<Cantico> titleSearchList, List<Cantico> lyricSearchList) {
        listHeader = new ArrayList<String>();
        resultListChild = new HashMap<String, List<Cantico>>();

        if(numberSearchList.size() > 0){
            listHeader.add(constants.SEARCH_BY_NUMBER);
            resultListChild.put(listHeader.get(0), numberSearchList);
        }

        if(titleSearchList.size() > 0){
            listHeader.add(constants.SEARCH_BY_TITLE);
            resultListChild.put(listHeader.get(listHeader.size() - 1), titleSearchList);
        }

        if(lyricSearchList.size() > 0){
            listHeader.add(constants.SEARCH_BY_LYRICS);
            resultListChild.put(listHeader.get(listHeader.size() - 1), lyricSearchList);
        }

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
