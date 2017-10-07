package br.com.ippontadareia.cancioneiroippa.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.ippontadareia.cancioneiroippa.R;
import br.com.ippontadareia.cancioneiroippa.dao.TamanhoFonteDAO;
import br.com.ippontadareia.cancioneiroippa.helper.Constants;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;
import br.com.ippontadareia.cancioneiroippa.modelo.TamanhoFonte;

/**
 * Created by lucasgasparquaresma on 3/9/17.
 */

public class SongsAdapter extends BaseAdapter {

    private final List<Cantico> canticos;
    private final Context context;

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

        TextView titleField = view.findViewById(R.id.item_title);
        TextView searchedLineField = view.findViewById(R.id.item_search_line);
        TextView firstLineField = view.findViewById(R.id.item_first_line);
        ImageView favoriteField = view.findViewById(R.id.item_favorite);

        TamanhoFonteDAO fontDAO = new TamanhoFonteDAO(context);
        TamanhoFonte sizes = fontDAO.selectSizes();

        titleField.setText(cantico.getNumber() + " - " + cantico.getTitle());
        titleField.setTextSize(sizes.getListTitleSize());

        if(firstLineField != null){
            String[] lyric = cantico.getLyrics().split("\n");
            String firstLine = lyric[0];

            if(Constants.CHORUS.equals(firstLine)){
                firstLine = lyric[1];
            }

            if(firstLine.length() > Constants.LYRICSMAXLENGHT){
                firstLine = String.valueOf(firstLine.subSequence(0, Constants.LYRICSMAXLENGHT));
                firstLine = firstLine + "...";
            }
            firstLineField.setText(firstLine);
            firstLineField.setTextSize(sizes.getListLyricSize());
        } else if(firstLineField == null){
            searchedLineField.setVisibility(View.GONE);
        }
        if(favoriteField != null){
            if(cantico.isFavorite()){
                favoriteField.setImageResource(R.drawable.shorter_favorite_on);
            } else {
                favoriteField.setImageResource(R.drawable.shorter_favorite_off);
            }
        }

        return view;
    }
}
