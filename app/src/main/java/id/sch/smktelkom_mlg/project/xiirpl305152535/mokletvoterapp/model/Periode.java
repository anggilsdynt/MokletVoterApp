package id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Pasha Anisa on 11/30/2016.
 */
public class Periode {
    public String judul;
    public String deskripsi;
    public Drawable foto;

    public Periode(String judul, String deskripsi, Drawable foto)
    {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }
}
