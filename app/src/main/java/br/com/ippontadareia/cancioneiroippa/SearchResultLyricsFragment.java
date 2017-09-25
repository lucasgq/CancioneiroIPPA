package br.com.ippontadareia.cancioneiroippa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.ippontadareia.cancioneiroippa.adapter.SongsAdapter;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;

/**
 * Created by lucasgasparquaresma on 23/09/17.
 */

public class SearchResultLyricsFragment extends Fragment {

    private ListView lyricsSongList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewLyricsList = inflater.inflate(R.layout.fragment_search_lyrics_result, container, false);

        Bundle params = getArguments();
        List<Cantico> resultList = (List<Cantico>) params.getSerializable("lyrcList");

        if(resultList != null && resultList.size() > 0){
            SongsAdapter adapter = new SongsAdapter(resultList, getContext());
            lyricsSongList = (ListView) viewLyricsList.findViewById(R.id.searched_lyrics_list);
            //searched_list

            lyricsSongList.setAdapter(adapter);

            lyricsSongList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                    Cantico cantico = (Cantico) lyricsSongList.getItemAtPosition(position);

                    Intent intentGoToLyrics = new Intent(getContext(), LyricsActivity.class);
                    intentGoToLyrics.putExtra("cantico", cantico);
                    startActivity(intentGoToLyrics);
                }
            });

        }

        return viewLyricsList;
    }
}
