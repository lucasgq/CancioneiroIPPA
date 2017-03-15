package br.com.ippontadareia.cancioneiroippa;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.ippontadareia.cancioneiroippa.dao.CanticoDAO;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;

public class SearchPopUpActivity extends AppCompatActivity {

    private static final String SEARCH_BY_NUMBER = "Buscar por Número";
    private static final String SEARCH_BY_TITLE = "Buscar por Título";
    private static final String SEARCH_BY_LYRICS = "Buscar por Letra";
    private TextView searchArgument;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_pop_up);
        getWindow().setLayout(ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.WRAP_CONTENT);

        searchArgument = (TextView) findViewById(R.id.search_value);

        List<String> spinnerSearchOptions = new ArrayList<String>();
        spinnerSearchOptions.add(SEARCH_BY_NUMBER);
        spinnerSearchOptions.add(SEARCH_BY_TITLE);
        spinnerSearchOptions.add(SEARCH_BY_LYRICS);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SearchPopUpActivity.this,
                R.layout.support_simple_spinner_dropdown_item, spinnerSearchOptions);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        final Spinner spinnerOptions = (Spinner) findViewById(R.id.search_opitions_spinner);
        spinnerOptions.setAdapter(adapter);

        Button doSearch = (Button) findViewById(R.id.do_search);
        doSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchOptionSelected = spinnerOptions.getSelectedItem().toString();

                Cantico cantico = new Cantico();
                List<Cantico> canticoList = new ArrayList<Cantico>();
                CanticoDAO dao = new CanticoDAO(SearchPopUpActivity.this);

                if(SEARCH_BY_NUMBER.equals(searchOptionSelected)){
                    cantico.setNumber(Long.valueOf(searchArgument.getText().toString().trim()));
                    cantico = dao.selectByNumber(cantico.getNumber());

                    if(cantico != null){
                        Intent intentGoToLyrics = new Intent(SearchPopUpActivity.this, LyricsActivity.class);
                        intentGoToLyrics.putExtra("cantico", cantico);
                        startActivity(intentGoToLyrics);
                    } else {
                        Toast.makeText(SearchPopUpActivity.this, "Nenhum cântico encontrado", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    String argument = searchArgument.getText().toString().trim();

                    if (SEARCH_BY_TITLE.equals(searchOptionSelected)) {
                        cantico.setTitle(argument);
                        canticoList = dao.selectByTitle(cantico.getTitle());

                        if (canticoList.size() == 0) {
                            Toast.makeText(SearchPopUpActivity.this, "Nenhum cântico encontrado", Toast.LENGTH_SHORT).show();
                        } else if (canticoList.size() == 1) {
                            Intent intentGoToSummary = new Intent(SearchPopUpActivity.this, LyricsActivity.class);
                            intentGoToSummary.putExtra("cantico", canticoList.get(0));
                            startActivity(intentGoToSummary);
                        } else {
                            Intent intentGoToSummary = new Intent(SearchPopUpActivity.this, SummaryActivity.class);
                            intentGoToSummary.putExtra("selectByTitleList", (ArrayList<Cantico>) canticoList);
                            intentGoToSummary.putExtra("title", argument);
                            startActivity(intentGoToSummary);
                        }

                    } else if (SEARCH_BY_LYRICS.equals(searchOptionSelected)) {
                        cantico.setLyrics(argument);
                        canticoList = dao.selectByLyrics(cantico.getLyrics());

                        if (canticoList.size() == 0) {
                            Toast.makeText(SearchPopUpActivity.this, "Nenhum cântico encontrado", Toast.LENGTH_SHORT).show();
                        } else if (canticoList.size() == 1) {
                            Intent intentGoToSummary = new Intent(SearchPopUpActivity.this, LyricsActivity.class);
                            intentGoToSummary.putExtra("cantico", canticoList.get(0));
                            startActivity(intentGoToSummary);
                        } else {
                            Intent intentGoToSummary = new Intent(SearchPopUpActivity.this, SummaryActivity.class);
                            intentGoToSummary.putExtra("selectByLyricsList", (ArrayList<Cantico>) canticoList);
                            intentGoToSummary.putExtra("lyrics", argument);
                            startActivity(intentGoToSummary);
                        }
                    }
                }
            }
        });


    }
}
