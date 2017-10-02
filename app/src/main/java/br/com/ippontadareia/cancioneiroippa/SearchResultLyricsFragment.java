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

public class SearchResultLyricsFragment extends Fragment {

    private ListView lyricsSongList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewList = inflater.inflate(R.layout.fragment_search_lyrics_result, container, false);
        //TextView titleText = viewList.findViewById(R.id.title_list_lyrics);

        Bundle params = getArguments();
        List<Cantico> resultLyricsList = (List<Cantico>) params.getSerializable("lyrcList");
        List<Cantico> resultTitleList = (List<Cantico>) params.getSerializable("titleList");
        List<Cantico> resultNumberList = (List<Cantico>) params.getSerializable("numberList");

        if(resultLyricsList != null && resultLyricsList.size() > 0){
//            titleText.setVisibility(View.VISIBLE);
//            titleText.setText(R.string.list_lyrics_text);
            SongsAdapter adapter = new SongsAdapter(resultLyricsList, getContext());
            if(resultTitleList.size() > 0 && resultNumberList.size() > 0){
                lyricsSongList = (ListView) viewList.findViewById(R.id.searched_lyrics_list);
            } else if(resultNumberList.size() > 0 || resultTitleList.size() > 0){
                lyricsSongList = (ListView) viewList.findViewById(R.id.searched_title_list);
            } else if (resultTitleList.size() < 0 && resultNumberList.size() < 0){
                lyricsSongList = (ListView) viewList.findViewById(R.id.searched_number_list);
            }

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
//        else {
//            titleText.setVisibility(View.INVISIBLE);
//        }

        return viewList;
    }
}
