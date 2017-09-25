package br.com.ippontadareia.cancioneiroippa.modelo;

import java.io.Serializable;

/**
 * Created by lucasgasparquaresma on 10/04/17.
 */
public class TamanhoFonte implements Serializable {

    private Long Id;
    private Long titleSize;
    private Long lyricSize;
    private Long listTitleSize;
    private Long listLyricSize;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getTitleSize() {
        return titleSize;
    }

    public void setTitleSize(Long titleSize) {
        this.titleSize = titleSize;
    }

    public Long getLyricSize() {
        return lyricSize;
    }

    public void setLyricSize(Long lyricSize) {
        this.lyricSize = lyricSize;
    }

    public Long getListTitleSize() {
        return listTitleSize;
    }

    public void setListTitleSize(Long listTitleSize) {
        this.listTitleSize = listTitleSize;
    }

    public Long getListLyricSize() {
        return listLyricSize;
    }

    public void setListLyricSize(Long listLyricSize) {
        this.listLyricSize = listLyricSize;
    }
}
