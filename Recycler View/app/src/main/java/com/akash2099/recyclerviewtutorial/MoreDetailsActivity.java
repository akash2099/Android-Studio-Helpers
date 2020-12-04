package com.akash2099.recyclerviewtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MoreDetailsActivity extends AppCompatActivity {
    ImageView mainImageView;
    TextView title,desc;
    String data1,data2;
    int myImageViewData;

    Animation topAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_details);
        title=(TextView)findViewById(R.id.program_title_textView_details);
        desc=(TextView)findViewById(R.id.program_desc_details_textView);
        mainImageView=(ImageView)findViewById(R.id.logo_details_imageView);

        // Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        // Setting animations
        mainImageView.setAnimation(topAnim);
        title.setAnimation(bottomAnim);
        desc.setAnimation(bottomAnim);

        getData();
        setData();
    }

    private void getData(){
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1")&&
        getIntent().hasExtra("data2")){
            data1=getIntent().getStringExtra("data1");
            data2=getIntent().getStringExtra("data2");
            myImageViewData=getIntent().getIntExtra("myImage",1);
        }
        else{
            Toast.makeText(this, "No data received!", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.setText(data1);
        desc.setText(data2);
        mainImageView.setImageResource(myImageViewData);
    }
}
