package br.com.ippontadareia.cancioneiroippa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import br.com.ippontadareia.cancioneiroippa.R;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;

/**
 * Created by lucasgasparquaresma on 3/9/17.
 */

public class SongsAdapter extends BaseAdapter {

    private final List<Cantico> canticos;
    private final Context context;
    private final Integer lyricsMaxLength = 50;
    private final String chorus = "[Coro]";

    public SongsAdapter(List<Cantico> canticos, Context context) {
        this.canticos = canticos;
        this.context = context;
    }


    @Override
    public int getCount() {
        return canticos.size();
    }

    @Override
    public Object getItem(int position) {
        return canticos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return canticos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cantico cantico = canticos.get(position);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView titleField = (TextView) view.findViewById(R.id.item_title);
        TextView firstLineField = (TextView) view.findViewById(R.id.item_first_line);
        ImageButton favoriteField = (ImageButton) view.findViewById(R.id.item_favorite);

        titleField.setText(cantico.getNumber() + " - " + cantico.getTitle());
        if(firstLineField != null){
            String[] lyric = cantico.getLyrics().split("\n");
            String firstLine = lyric[0];

            if(chorus.equals(firstLine)){
                firstLine = lyric[1];
            }

            if(firstLine.length() > lyricsMaxLength){
                firstLine = String.valueOf(firstLine.subSequence(0, lyricsMaxLength));
                firstLine = firstLine + "...";
            }
            firstLineField.setText(firstLine);
        }
        if(favoriteField != null){
            if(cantico.isFavorite()){
                favoriteField.setImageResource(R.drawable.favorite_on);
            } else {
                favoriteField.setImageResource(R.drawable.favorite_off);
            }
        }

        return view;
    }
}
