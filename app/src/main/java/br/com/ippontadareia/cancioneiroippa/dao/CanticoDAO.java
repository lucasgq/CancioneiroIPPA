package br.com.ippontadareia.cancioneiroippa.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.ippontadareia.cancioneiroippa.modelo.Cantico;
import br.com.ippontadareia.cancioneiroippa.songs.SongList;

/**
 * Created by lucasgasparquaresma on 1/17/17.
 */

public class CanticoDAO extends SQLiteOpenHelper {

    public CanticoDAO(Context context) {
        super(context, "Cancioneiro", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE Canticos (Id INTEGER PRIMARY KEY, Number INTEGER NOT NULL, Title TEXT NOT NULL, Lyrics TEXT NOT NULL, Favorite BOOLEAN NOT NULL);";
        db.execSQL(createTable);

//        String createTableFontSize = "CREATE TABLE Tamanho (ID INTEGER PRIMARY KEY, ListTitle INTEGER NOT NULL, ListLyrics INTEGER NOT NULL, Title INTEGER NOT NULL, Lyrics NOT NULL);";
//        db.execSQL(createTableFontSize);
        createSongs(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newVersion) {

    }
    
    
    public void createSongs(SQLiteDatabase db){
        SongList songList = new SongList();
        List<Cantico> listOfSong = new ArrayList<Cantico>();
        
        listOfSong = songList.fillSongList();

        for (Cantico cantico: listOfSong) {
            ContentValues dados = getContentValuesCanticos(cantico);
            db.insert("Canticos", null, dados);
        }
    }


    private ContentValues getContentValuesCanticos(Cantico cantico) {
        ContentValues dados = new ContentValues();
        dados.put("Number", cantico.getNumber());
        dados.put("Title", cantico.getTitle());
        dados.put("Lyrics", cantico.getLyrics());
        dados.put("Favorite", "false");
        return dados;
    }

    public List<Cantico> selectAll(){
        List<Cantico> canticos = new ArrayList<Cantico>();

        String select = "SELECT * FROM Canticos ORDER BY Number;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(select, null);

        canticos = getSongList(canticos, c);
        c.close();


        return canticos;
    }

    public List<Cantico> selectByLyrics(String lyrics){
        List<Cantico> canticos = new ArrayList<Cantico>();

        String[] sqlLyrics = new String[1];
        sqlLyrics [0] = "%" + lyrics + "%";

        String selectSingle = "SELECT * FROM Canticos WHERE Lyrics LIKE ? ORDER BY Number;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(selectSingle, sqlLyrics);

        canticos = getSongList(canticos, c);
        c.close();

        return canticos;
    }

    public Cantico selectByNumber(Long songNumber){
        Cantico cantico = new Cantico();

        String selectSingle = "SELECT * FROM Canticos WHERE Number = " + songNumber;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(selectSingle, null);

        if(c.moveToNext()){
            cantico.setId(c.getLong(c.getColumnIndex("Id")));
            cantico.setNumber(c.getLong(c.getColumnIndex("Number")));
            cantico.setTitle(c.getString(c.getColumnIndex("Title")));
            cantico.setLyrics(c.getString(c.getColumnIndex("Lyrics")));
            cantico.setFavorite(Boolean.parseBoolean(c.getString(c.getColumnIndex("Favorite"))));
        }

        return cantico;
    }

    public List<Cantico> selectByTitle(String title){
        List<Cantico> canticos = new ArrayList<Cantico>();

        String[] sqlTitle = new String[1];
        sqlTitle [0] = "%" + title + "%";

        String select = "SELECT * FROM Canticos WHERE Title LIKE ? ORDER BY Number;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(select, sqlTitle);

        canticos = getSongList(canticos, c);
        c.close();


        return canticos;
    }

    public Cantico setFavorite(Cantico cantico){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();

        if(cantico.isFavorite()){
            cv.put("Favorite", "false");
        } else {
            cv.put("Favorite", "true");
        }

        db.update("Canticos", cv, "Id=" + cantico.getId(), null);
        db.close();

        cantico = selectByNumber(cantico.getNumber());

        return cantico;
    }

    public List<Cantico> listFavorites(){
        List<Cantico> canticos = new ArrayList<Cantico>();
        SQLiteDatabase db = getReadableDatabase();

        String selectFavorites = "SELECT * FROM Canticos WHERE Favorite = ? ORDER BY Number";
        Cursor c = db.rawQuery(selectFavorites, new String[]{"true"});

        canticos = getSongList(canticos, c);
        c.close();

        return canticos;
    }

    public void erase(Cantico cantico) {
        SQLiteDatabase db = getWritableDatabase();

        String[] params = {cantico.getId().toString()};
        //db.delete("Canticos", "Id = ?", params);
        db.delete("Canticos", null, null);
    }

    private List<Cantico> getSongList(List<Cantico> canticos, Cursor c) {

        while(c.moveToNext()){
            Cantico cantico = new Cantico();
            cantico.setId(c.getLong(c.getColumnIndex("Id")));
            cantico.setNumber(c.getLong(c.getColumnIndex("Number")));
            cantico.setTitle(c.getString(c.getColumnIndex("Title")));
            cantico.setLyrics(c.getString(c.getColumnIndex("Lyrics")));
            cantico.setFavorite(Boolean.parseBoolean(c.getString(c.getColumnIndex("Favorite"))));

            canticos.add(cantico);
        }

        return canticos;
    }

}
