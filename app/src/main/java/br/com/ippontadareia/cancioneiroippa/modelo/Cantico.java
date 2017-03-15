package br.com.ippontadareia.cancioneiroippa.modelo;

import java.io.Serializable;

/**
 * Created by lucasgasparquaresma on 1/17/17.
 */

public class Cantico implements Serializable {

    private Long id;
    private Long Number;
    private String Title;
    private String Lyrics;
    private boolean Favorite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return Number;
    }

    public void setNumber(Long number) {
        Number = number;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLyrics() {
        return Lyrics;
    }

    public void setLyrics(String lyrics) {
        Lyrics = lyrics;
    }

    public boolean isFavorite() {
        return Favorite;
    }

    public void setFavorite(boolean favorite) {
        Favorite = favorite;
    }

    @Override
    public String toString() {
        return getNumber() + " - " + getTitle();
    }
}
