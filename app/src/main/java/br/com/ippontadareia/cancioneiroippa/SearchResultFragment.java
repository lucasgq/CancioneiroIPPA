package br.com.ippontadareia.cancioneiroippa;


import android.content.Intent;
import android.os.Bundle;
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

public class SearchResultFragment extends Fragment {

    private ListView songList;
    private ListView titleSongList;
    private ListView lyricsSongList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewList = inflater.inflate(R.layout.fragment_search_result, container, false);
        //TextView titleText = viewList.findViewById(R.id.title_list_number);

        Bundle params = getArguments();
        List<Cantico> resultNumberList = (List<Cantico>) params.getSerializable("numberList");

        if(resultNumberList != null && resultNumberList.size() > 0){
//            titleText.setVisibility(View.VISIBLE);
//            titleText.setText(R.string.list_number_text);
            SongsAdapter adapter = new SongsAdapter(resultNumberList, getContext());
            songList = (ListView) viewList.findViewById(R.id.searched_number_list);
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
//        else {
//            titleText.setVisibility(View.INVISIBLE);
//        }
        return viewList;
    }

}
