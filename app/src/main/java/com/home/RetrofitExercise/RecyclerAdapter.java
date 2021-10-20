package com.home.RetrofitExercise;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private static final String TAG = "RecyclerAdapter";
    private final List<Post> postList = new ArrayList<>();
    private final List<Comment> commentList = new ArrayList<>();

    private String postORComment = "";

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


//        holder.userID.setText("userID: " + post.getUserID());
//        holder.ID.setText("ID: " + post.getID());
//        holder.title.setText("title: " + post.getTitle());
//        holder.textBody.setText("text: " + post.getText());
        if (postORComment.equals("post")) {
            String content = "";

            Post post = postList.get(position);
            content += "ID: " + post.getID() + "\n";
            content += "User ID: " + post.getUserID() + "\n";
            content += "Title: " + post.getTitle() + "\n";
            content += "Text: " + post.getText() + "\n\n";

            holder.textBody.setText(content);

        } else if (postORComment.equals("comment")) {
            String content = "";
            Comment comment = commentList.get(position);
            content += "ID: " + comment.getId() + "\n";
            content += "Post ID: " + comment.getPostId() + "\n";
            content += "Name: " + comment.getName() + "\n";
            content += "Email: " + comment.getEmail() + "\n";
            content += "Text: " + comment.getText() + "\n\n";
            holder.textBody.setText(content);
        }
    }

    @Override
    public int getItemCount() {
        return postList.size() | commentList.size();
    }

    public void clearPostList() {
        postList.clear();
    }

    public void clearCommentList() {
        commentList.clear();
    }

    public void addPost(Post post) {
        postList.add(post);
        this.postORComment = "post";
        notifyDataSetChanged();
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
        this.postORComment = "comment";
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textBody = itemView.findViewById(R.id.text_body);
        }
    }
}

