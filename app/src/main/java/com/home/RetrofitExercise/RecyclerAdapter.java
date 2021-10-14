package com.home.RetrofitExercise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final List<Post> postList = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Post post = postList.get(position);

        holder.userID.setText(post.getUserID());
        holder.ID.setText(post.getID());
        holder.title.setText(post.getTitle());
        holder.textBody.setText(post.getText());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void addPost(Post post) {
        postList.add(post);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView userID;
        private final TextView ID;
        private final TextView title;
        private final TextView textBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userID = itemView.findViewById(R.id.userID);
            ID = itemView.findViewById(R.id.ID);
            title = itemView.findViewById(R.id.title);
            textBody = itemView.findViewById(R.id.text_body);
        }
    }
}

