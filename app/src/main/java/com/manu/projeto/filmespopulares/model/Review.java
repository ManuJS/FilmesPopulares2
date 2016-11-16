package com.manu.projeto.filmespopulares.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by emanu on 01/11/2016.
 */
public class Review {

    private String id;
    private String author;
    private String content;

    public Review() {

    }

    public Review(JSONObject trailer) throws JSONException {
        this.id = trailer.getString("id");
        this.author = trailer.getString("author");
        this.content = trailer.getString("content");
    }

    public String getId() { return id; }

    public String getAuthor() { return author; }

    public String getContent() { return content; }
}
