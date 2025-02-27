package vn.edu.usth.facebook.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.edu.usth.facebook.CommentActivity;
import vn.edu.usth.facebook.R;
import vn.edu.usth.facebook.fragment.HomeFragment;
import vn.edu.usth.facebook.fragment.ProfileFragment;
import vn.edu.usth.facebook.model.Post;

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.ViewHolder>{
    private ArrayList<Post> posts;
    private ProfileFragment context;

    public UserProfileAdapter(ArrayList<Post> posts, ProfileFragment context) {
        this.posts = posts;
        this.context = context;
    }


    @NonNull
    @Override
    public UserProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_row, parent, false);
        return new UserProfileAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserProfileAdapter.ViewHolder holder, int position) {
        Post post = posts.get(position);
        Picasso.get().load(post.getAuthor_image()).into(holder.author_img);
        holder.author_name.setText(post.getAuthor_name());
        holder.time_post.setText(post.getPostDate());
        holder.post_description.setText(post.getPost_description());
        Picasso.get().load(post.getPost_image()).into(holder.post_img);
        holder.post_likes.setText(post.getPost_likes());
        holder.post_comments.setText(post.getPost_comments());

        holder.post_likes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.post_comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CommentActivity.class);
                view.getContext().startActivity(intent);
            }
        });
//        holder.author_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AppCompatActivity activity = (AppCompatActivity) view.getContext();
//                Fragment myFragment = new ProfileFragment();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, myFragment).addToBackStack(null).commit();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView author_img;
        private TextView author_name, time_post, post_description;
        private ImageView post_img;
        private TextView post_likes, post_comments;
        private LinearLayout post_share;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            author_img = itemView.findViewById(R.id.idCVAuthor);
            author_name = itemView.findViewById(R.id.idTVAuthorName);
            time_post = itemView.findViewById(R.id.idTVTime);
            post_description = itemView.findViewById(R.id.idTVDescription);
            post_img = itemView.findViewById(R.id.idIVPost);
            post_likes = itemView.findViewById(R.id.idTVLikes);
            post_comments = itemView.findViewById(R.id.idTVComments);
            post_share = itemView.findViewById(R.id.idLLShare);
        }
    }
}
