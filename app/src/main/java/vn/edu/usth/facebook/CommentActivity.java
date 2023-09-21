package vn.edu.usth.facebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import vn.edu.usth.facebook.adapter.CommentAdapter;
import vn.edu.usth.facebook.adapter.FriendsAdapter;
import vn.edu.usth.facebook.fragment.FriendsFragment;
import vn.edu.usth.facebook.model.Comments;
import vn.edu.usth.facebook.model.Friends;

public class CommentActivity extends AppCompatActivity {
    private RecyclerView comment_recyclerView;
    private ArrayList<Comments> comments;
    private CommentAdapter commentAdapter;
    private CircleImageView comment_ava;
    private TextView comment_name, comment_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        comment_recyclerView = findViewById(R.id.comment_recyclerView);
        comments = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            String comment_ava = "https://picsum.photos/600/300?random&"+i;
            String comment_name = "ST";
            String comment_content = "this is a test comment";

            Comments comment = new Comments(comment_ava, comment_name, comment_content);
            comments.add(comment);
            CommentAdapter adapter = new CommentAdapter(comments, CommentActivity.this);
            RecyclerView recyclerView = findViewById(R.id.comment_recyclerView);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(adapter);
        }


    }
}
//        Toolbar toolbar = findViewById(R.id.comment_toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Comments");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//
//        write_comment = findViewById(R.id.write_comment);
//        send_comment = findViewById(R.id.send_comment);
//
//        send_comment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//    }
