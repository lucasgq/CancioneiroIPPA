package br.com.ippontadareia.cancioneiroippa;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import br.com.ippontadareia.cancioneiroippa.adapter.SongsAdapter;
import br.com.ippontadareia.cancioneiroippa.dao.TamanhoFonteDAO;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;
import br.com.ippontadareia.cancioneiroippa.modelo.TamanhoFonte;

/**
 * Created by lucasgasparquaresma on 04/04/17.
 */

public class Settings extends DialogFragment {

    public static final Integer FONT_SIZE = 4;
    public static final Integer MIN_FONT_SIZE = 14;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.settings_activity, null);

        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                //getApplicationContext().getSharedPreferences("config", Context.MODE_PRIVATE);

        builder.setView(view)
                //.setTitle(R.string.action_settings)
                .setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int id) {
            }
        });

        final TamanhoFonteDAO fontDAO = new TamanhoFonteDAO(getContext());
        final SongsAdapter adapter = null;

        SeekBar fontSizeSB = (SeekBar) view.findViewById(R.id.seekbar_font_size);
        final TextView fontSizeIndicator = (TextView) view.findViewById(R.id.font_size_selected);
        TamanhoFonte tf = fontDAO.selectSizes();
        fontSizeIndicator.setText(tf.getLyricSize().toString());

        fontSizeSB.setProgress(sharedPreferences.getInt("fontSize", FONT_SIZE));

        fontSizeSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fontSizeIndicator.setText(progress + MIN_FONT_SIZE + "");
                fontDAO.changeFontsize(progress + MIN_FONT_SIZE);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                sharedPreferences.edit().putInt("fontSize", seekBar.getProgress()).commit();
                //adapter.notifyDataSetChanged();
                //sectionsPagerAdapter.notifyDataSetChanged();
            }
        });

        return builder.create();
    }
}
