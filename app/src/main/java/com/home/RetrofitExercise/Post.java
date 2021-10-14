package com.home.RetrofitExercise;

import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("userId")
    private int userId;

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String text;

    public int getUserID() {
        return userId;
    }

    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
