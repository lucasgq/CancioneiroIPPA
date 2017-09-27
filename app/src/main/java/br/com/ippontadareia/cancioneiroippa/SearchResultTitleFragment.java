package br.com.ippontadareia.cancioneiroippa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.com.ippontadareia.cancioneiroippa.adapter.SongsAdapter;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;

/**
 * Created by lucasgasparquaresma on 23/09/17.
 */

public class SearchResultTitleFragment extends Fragment {

    private ListView titleSongList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewTitleList = inflater.inflate(R.layout.fragment_search_title_result, container, false);
        TextView titleText = viewTitleList.findViewById(R.id.title_list_title);

        Bundle params = getArguments();
        List<Cantico> resultList = (List<Cantico>) params.getSerializable("titleList");

        if(resultList != null && resultList.size() > 0){
            titleText.setVisibility(View.VISIBLE);
            titleText.setText(R.string.list_title_text);
            SongsAdapter adapter = new SongsAdapter(resultList, getContext());
            titleSongList = (ListView) viewTitleList.findViewById(R.id.searched_title_list);

            titleSongList.setAdapter(adapter);

            titleSongList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                    Cantico cantico = (Cantico) titleSongList.getItemAtPosition(position);

                    Intent intentGoToLyrics = new Intent(getContext(), LyricsActivity.class);
                    intentGoToLyrics.putExtra("cantico", cantico);
                    startActivity(intentGoToLyrics);
                }
            });
        } else {
            titleText.setVisibility(View.INVISIBLE);
        }

        return viewTitleList;
    }
}
