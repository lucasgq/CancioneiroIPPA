package br.com.ippontadareia.cancioneiroippa.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;

import java.io.Console;
import java.util.HashMap;
import java.util.List;

import br.com.ippontadareia.cancioneiroippa.R;
import br.com.ippontadareia.cancioneiroippa.dao.TamanhoFonteDAO;
import br.com.ippontadareia.cancioneiroippa.helper.Constants;
import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;
import br.com.ippontadareia.cancioneiroippa.modelo.TamanhoFonte;

/**
 * Created by lucas.quaresma on 30/09/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listHeaders;
    private HashMap<String, List<Cantico>> resultList;
    private String argument;

    public ExpandableListAdapter(Context context, List<String> listHeaders, HashMap<String, List<Cantico>> resultList, String argument) {
        this.context = context;
        this.listHeaders = listHeaders;
        this.resultList = resultList;
        this.argument = argument;
    }

    @Override
    public int getGroupCount() {
        return this.resultList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.resultList.get(this.listHeaders.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.resultList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.resultList.get(this.listHeaders.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = listHeaders.get(groupPosition);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_group, null);
        }

        TextView labelListHeader = convertView.findViewById(R.id.list_group_label);
        labelListHeader.setTypeface(null, Typeface.ITALIC);

        TamanhoFonteDAO fontDAO = new TamanhoFonteDAO(context);
        TamanhoFonte sizes = fontDAO.selectSizes();
        labelListHeader.setTextSize(sizes.getLyricSize() - 2);
        labelListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        Cantico cantico = (Cantico) getChild(groupPosition, childPosition);

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.list_item, parent, false);
        }

        LinearLayout layout = view.findViewById(R.id.song_list_layout);
        TextView titleField = view.findViewById(R.id.item_title);
        TextView firstLineField = view.findViewById(R.id.item_first_line);
        TextView searchedLineField = view.findViewById(R.id.item_search_line);
        ImageView favoriteField = view.findViewById(R.id.item_favorite);

        TamanhoFonteDAO fontDAO = new TamanhoFonteDAO(context);
        TamanhoFonte sizes = fontDAO.selectSizes();

        titleField.setText(cantico.getNumber() + " - " + cantico.getTitle());
        System.out.printf("\n\n" + cantico.getNumber() + " - " + cantico.getTitle() + "\n");
        titleField.setTextSize(sizes.getListTitleSize());

        String[] lyric = cantico.getLyrics().split("\n");

        String searchedLine = "";

        if(searchedLineField != null){
            if(groupPosition == listHeaders.size() - 1){
                searchedLine = fitLyricsLine(lyric, searchedLine);
                searchedLineField.setText(Html.fromHtml(searchedLine));
                searchedLineField.setTextSize(sizes.getListLyricSize());
            } else{
                searchedLineField.setVisibility(View.GONE);
            }
        }

        if(firstLineField != null){
            String firstLine = lyric[0];

            if(Constants.CHORUS.equals(firstLine)){
                firstLine = lyric[1];
            }

            if(groupPosition == listHeaders.size() - 1){
                searchedLine = fitLyricsLine(lyric, searchedLine);
                firstLineField.setText(Html.fromHtml(searchedLine));
            } else {
                //firstLine = fitLyricsLength(firstLine);
                firstLineField.setText(firstLine);
            }
            firstLineField.setTextSize(sizes.getListLyricSize());
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

    private String fitLyricsLine(String[] lyric, String lyricsLine) {
        for (String aLyric : lyric) {
            if (aLyric.toLowerCase().contains(argument.toLowerCase())) {
                String line = aLyric;
                //line = fitLyricsLength(line);
                if (lyricsLine.isEmpty()) {
                    line = enlightenArgument(line);
                    lyricsLine = line;
                } else {
                    line = enlightenArgument(line);
                    lyricsLine = lyricsLine + "<br>" + line;
                }
            }
        }
        return lyricsLine;
    }

    @NonNull
    private String enlightenArgument(String line) {
        int initialPosition = line.toLowerCase().indexOf(argument.toLowerCase());
        int finalPosition = initialPosition + argument.length();

        line = line.substring(0, initialPosition ) + "<font color=#3C01FC>" + line.substring(initialPosition, finalPosition) + "</font>" + line.substring(finalPosition, line.length());
        return line;
    }

    @NonNull
    private String fitLyricsLength(String line) {
        if(line.length() > Constants.LYRICSMAXLENGHT){
            line = String.valueOf(line.subSequence(0, Constants.LYRICSMAXLENGHT));
            line = line + "...";
        }
        return line;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
