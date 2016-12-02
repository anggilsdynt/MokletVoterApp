package id.sch.smktelkom_mlg.project.xiirpl305152535.mokletvoterapp.model;

import java.io.Serializable;

/**
 * Created by Pasha Anisa on 10/29/2016.
 */
public class Siswa implements Serializable {
    public String judul;
    public String deskripsi;
    public String detail;
    public String lokasi;
    public String foto;

    public Siswa(String judul, String deskripsi, String detail, String lokasi, String foto)
    {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.detail = detail;
        this.lokasi = lokasi;
        this.foto = foto;
    }
}
