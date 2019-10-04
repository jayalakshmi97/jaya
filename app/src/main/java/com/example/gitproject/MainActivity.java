package com.example.gitproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button camera, save;
    ImageView imgview;
    private static final int CAMERA_REQUEST = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgview = findViewById(R.id.imgview);
        camera = findViewById(R.id.btn_cam);
        save = findViewById(R.id.btn_save);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }

            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
                    Bitmap mphoto = (Bitmap) data.getExtras().get("data");
                    imgview.setImageBitmap(mphoto);
                }
            }


        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }
}