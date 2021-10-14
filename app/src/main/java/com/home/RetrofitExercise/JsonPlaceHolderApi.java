package com.home.RetrofitExercise;

import android.content.Intent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts")
    Call<List<Post>> getPostsWithId(
            @Query("userId") Integer id);

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postID);
}