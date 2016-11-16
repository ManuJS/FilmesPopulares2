package com.manu.projeto.filmespopulares.model;

import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;

import com.manu.projeto.filmespopulares.MainActivityFragment;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by emanu on 01/11/2016.
 */
public class Filme implements Parcelable {

    private int id;
    private String title; // titulo
    private String image; // imagem da capa
    private String image2; // imagem de fundo
    private String overview; //sinopse
    private String rating; // vote_average
    private String date; // data de lançamento

    public Filme() {

    }

    public Filme(JSONObject movie) throws JSONException {
        this.id = movie.getInt("id");
        this.title = movie.getString("title");
        this.image = movie.getString("poster_path");
        this.image2 = movie.getString("backdrop_path");
        this.overview = movie.getString("overview");
        this.rating = movie.getString("vote_average");
        this.date = movie.getString("release_date");
    }

    public Filme(Cursor cursor) {
        this.id = cursor.getInt(MainActivityFragment.COL_MOVIE_ID);
        this.title = cursor.getString(MainActivityFragment.COL_TITLE);
        this.image = cursor.getString(MainActivityFragment.COL_IMAGE);
        this.image2 = cursor.getString(MainActivityFragment.COL_IMAGE2);
        this.overview = cursor.getString(MainActivityFragment.COL_OVERVIEW);
        this.rating = cursor.getString(MainActivityFragment.COL_RATING);
        this.date = cursor.getString(MainActivityFragment.COL_DATE);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getImage2() {
        return image2;
    }

    public String getOverview() {
        return overview;
    }

    public String getRating() {
        return rating;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(image2);
        dest.writeString(overview);
        dest.writeString(rating);
        dest.writeString(date);
    }

    public static final Creator<Filme> CREATOR
            = new Creator<Filme>() {
        public Filme createFromParcel(Parcel in) {
            return new Filme(in);
        }

        public Filme[] newArray(int size) {
            return new Filme[size];
        }
    };

    private Filme(Parcel in) {
        id = in.readInt();
        title = in.readString();
        image = in.readString();
        image2 = in.readString();
        overview = in.readString();
        rating = in.readString();
        date = in.readString();
    }
}