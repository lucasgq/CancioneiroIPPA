package br.com.ippontadareia.cancioneiroippa.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.ippontadareia.cancioneiroippa.modelo.TamanhoFonte;

/**
 * Created by lucasgasparquaresma on 10/04/17.
 */

public class TamanhoFonteDAO extends SQLiteOpenHelper {
    public TamanhoFonteDAO(Context context) {
        super(context, "FontSize", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE TamanhoFonte (Id INTEGER PRIMARY KEY, Title INTEGER NOT NULL, Lyric INTEGER NOT NULL, ListTitle INTEGER NOT NULL, ListLyric INTEGER NOT NULL);";
        db.execSQL(createTable);

        fillTable(db);
    }

    private void fillTable(SQLiteDatabase db) {

        ContentValues dados = new ContentValues();
        dados.put("Title", "26");
        dados.put("Lyric", "24");
        dados.put("ListTitle", "18");
        dados.put("ListLyric", "16");

        db.insert("TamanhoFonte", null, dados);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void changeFontsize(Integer size){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        TamanhoFonte sizes = selectSizes();

        cv.put("Title", size + 2);
        cv.put("Lyric", size);
        cv.put("ListTitle", size);
        cv.put("ListLyric", size - 2);

        db.update("TamanhoFonte", cv, "Id=" + sizes.getId(), null);
        db.close();

    }

    public TamanhoFonte selectSizes(){
        TamanhoFonte sizes = new TamanhoFonte();

        String selectSingle = "SELECT * FROM TamanhoFonte ORDER BY Id ASC LIMIT 1;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(selectSingle, null);

        if(c.moveToNext()){
            sizes.setId(c.getLong(c.getColumnIndex("Id")));
            sizes.setTitleSize(c.getLong(c.getColumnIndex("Title")));
            sizes.setLyricSize(c.getLong(c.getColumnIndex("Lyric")));
            sizes.setListTitleSize(c.getLong(c.getColumnIndex("ListTitle")));
            sizes.setListLyricSize(c.getLong(c.getColumnIndex("ListLyric")));
        }

        return sizes;
    }
}
