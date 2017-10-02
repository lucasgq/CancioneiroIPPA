package br.com.ippontadareia.cancioneiroippa.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

    public ExpandableListAdapter(Context context, List<String> listHeaders, HashMap<String, List<Cantico>> resultList) {
        this.context = context;
        this.listHeaders = listHeaders;
        this.resultList = resultList;
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
        //Seleciona os headers de cada uma das listas
        String headerTitle = (String)listHeaders.get(groupPosition);
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

        TextView titleField = (TextView) view.findViewById(R.id.item_title);
        TextView firstLineField = (TextView) view.findViewById(R.id.item_first_line);
        ImageView favoriteField = (ImageView) view.findViewById(R.id.item_favorite);

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

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
