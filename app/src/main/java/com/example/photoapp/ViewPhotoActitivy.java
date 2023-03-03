package com.example.photoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewPhotoActitivy extends AppCompatActivity {
    ImageView imageView;
    TextView description, title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_photo);
        description = findViewById(R.id.iv_detail_description);
        title = findViewById(R.id.tv_detail_title);
        imageView = findViewById(R.id.iv_detail);

        int id = (int) getIntent().getLongExtra("id", 0);
        Picasso.get().load(PhotoData.getPhotoFromId(id, getApplicationContext()).getSource_photo()).resize(400, 500).centerCrop().into(imageView);
        title.setText(PhotoData.getPhotoFromId(id, getApplicationContext()).getTitle_photo());
        description.setText(PhotoData.getPhotoFromId(id, getApplicationContext()).getDescription_photo());

    }
}