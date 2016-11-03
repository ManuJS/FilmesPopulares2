package com.manu.projeto.filmespopulares.models;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.manu.projeto.filmespopulares.FragmentMain;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by emanu on 01/11/2016.
 */

public class Filme implements Parcelable {

    private int id;
    private String tituloOriginal;
    private String tituloFilme;
    private String sinopseFilme;
    private String dataEstreia;
    private String image;// drawable reference id
    private String mediaVoto;
    private String image2; // backdrop_path


    public Filme(Cursor cursor) {
        this.id = cursor.getInt(FragmentMain.COL_MOVIE_ID);
        this.tituloOriginal = cursor.getString(FragmentMain.COL_TITLE);
        this.tituloFilme = cursor.getString(FragmentMain.COL_TITLE);
        this.dataEstreia = cursor.getString(FragmentMain.COL_DATE);
        this.sinopseFilme = cursor.getString(FragmentMain.COL_OVERVIEW);
        this.image = cursor.getString(FragmentMain.COL_IMAGE);
        this.mediaVoto = cursor.getString(FragmentMain.COL_RATING);
        this.image2 = cursor.getString(FragmentMain.COL_IMAGE2);

    }


    public Filme() {

    }

    public Filme(JSONObject Filme) throws JSONException {
        this.id = Filme.getInt("id");
        this.tituloOriginal = Filme.getString("original_title");
        this.tituloFilme = Filme.getString("title");
        this.image = Filme.getString("poster_path");
        this.image2 = Filme.getString("backdrop_path");
        this.dataEstreia = Filme.getString("release_date");
        this.sinopseFilme = Filme.getString("overview");
        this.mediaVoto = Filme.getString("vote_average");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getSinopseFilme() {
        return sinopseFilme;
    }

    public void setSinopseFilme(String sinopseFilme) {
        this.sinopseFilme = sinopseFilme;
    }

    public String getDataEstreia() {
        return dataEstreia;
    }

    public void setDataEstreia(String dataEstreia) {
        this.dataEstreia = dataEstreia;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMediaVoto() {
        return mediaVoto;
    }

    public void setMediaVoto(String mediaVoto) {
        this.mediaVoto = mediaVoto;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public Filme(Parcel in) {
        id = in.readInt();
        tituloOriginal = in.readString();
        tituloFilme = in.readString();
        dataEstreia = in.readString();
        sinopseFilme = in.readString();
        image = in.readString();
        mediaVoto = in.readString();
        image2 = in.readString();
    }

    public static final Parcelable.Creator<Filme> CREATOR
            = new Parcelable.Creator<Filme>() {
        public Filme createFromParcel(Parcel in) {
            return new Filme(in);
        }

        public Filme[] newArray(int size) {
            return new Filme[size];
        }
    };

    public Filme(int id, String tituloOriginal, String tituloFilme,
                 String dataEstreia, String sinopseFilme, String image, String mediaVoto, String image2) {
        this.id = id;
        this.tituloOriginal = tituloOriginal;
        this.tituloFilme = tituloFilme;
        this.sinopseFilme = sinopseFilme;
        this.dataEstreia = dataEstreia;
        this.image = image;
        this.mediaVoto = mediaVoto;
        this.image2 = image2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(tituloOriginal);
        dest.writeString(tituloFilme);
        dest.writeString(dataEstreia);
        dest.writeString(sinopseFilme);
        dest.writeString(image);
        dest.writeString(mediaVoto);
        dest.writeString(image2);
    }
}
