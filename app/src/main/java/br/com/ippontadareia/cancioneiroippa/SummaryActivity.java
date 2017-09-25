package br.com.ippontadareia.cancioneiroippa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import br.com.ippontadareia.cancioneiroippa.adapter.SongsAdapter;
import br.com.ippontadareia.cancioneiroippa.dao.CanticoDAO;
import br.com.ippontadareia.cancioneiroippa.dao.TamanhoFonteDAO;
import br.com.ippontadareia.cancioneiroippa.helper.Constants;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;
import br.com.ippontadareia.cancioneiroippa.modelo.TamanhoFonte;

public class SummaryActivity extends AppCompatActivity {

    private ListView listaCanticos;
    private Cantico cantico;
    private List<Cantico> songList;
    SongsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(false);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitleMarginStart(0);

        Intent intent = getIntent();
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
        inflater.inflate(R.menu.toolbar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    private void loadSummary(){
        CanticoDAO dao = new CanticoDAO(this);
        List<Cantico> canticos = null;

        canticos = dao.selectAll();
        songList = canticos;

        dao.close();

        adapter = new SongsAdapter(canticos, this);
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
            case R.id.action_search:

                Intent intentGoToSearchPopUp = new Intent(SummaryActivity.this, SearchSongActivity.class);
                startActivity(intentGoToSearchPopUp);

                break;

            case R.id.action_favorite:

                CanticoDAO dao = new CanticoDAO(SummaryActivity.this);
                List<Cantico> listCanticos = new ArrayList<Cantico>();
                listCanticos = dao.listFavorites();
                Intent intentGoToFavoriteList = new Intent(SummaryActivity.this, FavoritesActivity.class);
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
                        adapter.notifyDataSetChanged();
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
}
