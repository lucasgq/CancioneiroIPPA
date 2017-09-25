package br.com.ippontadareia.cancioneiroippa;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.ippontadareia.cancioneiroippa.adapter.SongsAdapter;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;

public class SearchResultFragment extends Fragment {

    private ListView songList;
    private ListView titleSongList;
    private ListView lyricSongList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View viewNumberList = inflater.inflate(R.layout.fragment_search_result, container, false);

        Bundle params = getArguments();
        List<Cantico> resultList = (List<Cantico>) params.getSerializable("numberList");
        if(resultList != null && resultList.size() > 0){
            SongsAdapter adapter = new SongsAdapter(resultList, getContext());
            songList = (ListView) viewNumberList.findViewById(R.id.searched_number_list);
            //searched_list
            songList.setAdapter(adapter);

            songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                    Cantico cantico = (Cantico) songList.getItemAtPosition(position);

                    Intent intentGoToLyrics = new Intent(getContext(), LyricsActivity.class);
                    intentGoToLyrics.putExtra("cantico", cantico);
                    startActivity(intentGoToLyrics);
                }
            });
        }

        return viewNumberList;
    }

}
