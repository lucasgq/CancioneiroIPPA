package br.com.ippontadareia.cancioneiroippa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ippontadareia.cancioneiroippa.adapter.SongsAdapter;
import br.com.ippontadareia.cancioneiroippa.dao.CanticoDAO;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;

public class SummaryActivity extends AppCompatActivity {

    private ListView listaCanticos;
    private List<Cantico> selectAllList;
    private List<Cantico> favoriteList;
    private List<Cantico> selectByTitleList;
    private String title;
    private List<Cantico> selectByLyricsList;
    private String lyrics;
    private Cantico cantico;


    private SongbookHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setIcon(R.drawable.home);


        Intent intent = getIntent();
        selectAllList = (ArrayList<Cantico>) intent.getSerializableExtra("selectAllList");
        favoriteList = (ArrayList<Cantico>) intent.getSerializableExtra("favoriteList");
        selectByTitleList = (ArrayList<Cantico>) intent.getSerializableExtra("selectByTitleList");
        title = intent.getStringExtra("title");
        selectByLyricsList = (ArrayList<Cantico>) intent.getSerializableExtra("selectByLyricsList");
        lyrics = intent.getStringExtra("lyrics");
        cantico = (Cantico) intent.getSerializableExtra("cantico");

        listaCanticos = (ListView) findViewById(R.id.lista_canticos);

        listaCanticos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Cantico cantico = (Cantico) listaCanticos.getItemAtPosition(position);

                Intent intentGoToLyrics = new Intent(SummaryActivity.this, LyricsActivity.class);
                intentGoToLyrics.putExtra("cantico", cantico);
                startActivity(intentGoToLyrics);
            }
        });

        registerForContextMenu(listaCanticos);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_button, menu);
        inflater.inflate(R.menu.favorite_list_button, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void loadSummary(){
        CanticoDAO dao = new CanticoDAO(this);
        List<Cantico> canticos = null;

        if(favoriteList != null){
            canticos = dao.listFavorites();
        } else if(selectByTitleList != null){
            canticos = selectByTitleList;
        } else if (selectByLyricsList != null) {
            canticos = selectByLyricsList;
        } else if(selectAllList != null){
            canticos = selectAllList;
        } else {
            canticos = dao.selectAll();
        }

        dao.close();

        if(canticos.size() == 0){
            Toast.makeText(this, "Não há cânticos na lista de favoritos", Toast.LENGTH_SHORT).show();
        }

        SongsAdapter adapter = new SongsAdapter(canticos, this);
        listaCanticos.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadSummary();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem erase = menu.add("Deletar");
        erase.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Cantico cantico = (Cantico) listaCanticos.getItemAtPosition(info.position);

                CanticoDAO dao = new CanticoDAO(SummaryActivity.this);
                dao.erase(cantico);
                dao.close();
                loadSummary();

                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.search_song:

                Intent intentGoToSearchPopUp = new Intent(SummaryActivity.this, SearchPopUpActivity.class);
                startActivity(intentGoToSearchPopUp);

                break;

            case R.id.favorite_list:

                CanticoDAO dao = new CanticoDAO(SummaryActivity.this);
                List<Cantico> listCanticos = new ArrayList<Cantico>();
                listCanticos = dao.listFavorites();
                Intent intentGoToFavoriteList = new Intent(SummaryActivity.this, SummaryActivity.class);
                intentGoToFavoriteList.putExtra("favoriteList", (ArrayList<Cantico>) listCanticos);
                if(listCanticos.size() == 0){
                    Toast.makeText(SummaryActivity.this, "Não há cânticos na lista de favoritos", Toast.LENGTH_SHORT).show();
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
}
