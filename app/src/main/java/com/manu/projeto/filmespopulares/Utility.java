package com.manu.projeto.filmespopulares;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;

import com.manu.projeto.filmespopulares.data.MoviesContract;

/**
 * Created by emanu on 01/11/2016.
 */
public class Utility {

    public static int isFavorited(Context context, int id) {
        Cursor cursor = context.getContentResolver().query(
                MoviesContract.MovieEntry.CONTENT_URI,
                null,   // projection
                MoviesContract.MovieEntry.COLUMN_MOVIE_ID + " = ?", // selection
                new String[] { Integer.toString(id) },   // selectionArgs
                null    // sort order
        );
        int numRows = cursor.getCount();
        cursor.close();
        return numRows;
    }

    public static String buildImageUrl(int width, String fileName) {
        return "http://image.tmdb.org/t/p/w" + Integer.toString(width) + fileName;
    }
}