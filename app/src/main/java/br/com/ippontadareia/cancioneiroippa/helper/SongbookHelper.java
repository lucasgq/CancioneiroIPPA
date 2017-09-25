package br.com.ippontadareia.cancioneiroippa.helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.ippontadareia.cancioneiroippa.R;
import br.com.ippontadareia.cancioneiroippa.dao.TamanhoFonteDAO;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;
import br.com.ippontadareia.cancioneiroippa.modelo.TamanhoFonte;

/**
 * Created by lucasgasparquaresma on 1/17/17.
 */

public class SongbookHelper {

    private final TextView numberField;
    private final TextView titleField;
    private final TextView lyricsField;
    private final ImageView favoriteField;
    private final Context context;

    private Cantico cantico;

    public SongbookHelper(Activity activity, Context context) {
        lyricsField = (TextView) activity.findViewById(R.id.cantico_lyrics);
        titleField = (TextView) activity.findViewById(R.id.cantico_title);
        numberField = (TextView) activity.findViewById(R.id.cantico_number);
        favoriteField = (ImageView) activity.findViewById(R.id.cantico_favorite);
        this.context = context; 

        cantico = new Cantico();
    }

    public Cantico getCantico(){
        cantico.setNumber(Long.valueOf(numberField.getText().toString()));
        cantico.setTitle(titleField.getText().toString());
        cantico.setLyrics(lyricsField.getText().toString());

        return cantico;
    }

    public void fillScreen(Cantico cantico){
        if(numberField != null){
            numberField.setText(cantico.getNumber().toString());
        }

        TamanhoFonteDAO fontDAO = new TamanhoFonteDAO(context);
        TamanhoFonte sizes = fontDAO.selectSizes();

        titleField.setText(cantico.getNumber() + " - " + cantico.getTitle());
        lyricsField.setText(cantico.getLyrics());

        lyricsField.setTextSize(sizes.getLyricSize());
        titleField.setTextSize(sizes.getTitleSize());

        if(cantico.isFavorite()){
            favoriteField.setImageResource(R.drawable.shorter_favorite_on);
        } else {
            favoriteField.setImageResource(R.drawable.shorter_favorite_off);
        }
        this.cantico = cantico;
    }
}
