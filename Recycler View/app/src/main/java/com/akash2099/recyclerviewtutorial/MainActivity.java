package com.akash2099.recyclerviewtutorial;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    // Recycler view + Animation Splash screen

    String pl[],ld[];
    int ll[];

    // below array not required
    int programming_images[]={R.drawable.c_logo,R.drawable.golang_logo,R.drawable.java_logo,
            R.drawable.javascript_logo, R.drawable.python_logo,R.drawable.swift_logo};

    RecyclerView recyclerView,recyclerViewHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pl=getResources().getStringArray(R.array.programming_languages);
        ld=getResources().getStringArray(R.array.language_description);
        // check below line later
        ll=loadScreenIcons();

        recyclerView=findViewById(R.id.recycler_view);
        recyclerViewHorizontal=findViewById(R.id.recycler_view_horizontal);

        MyRecyclerAdapter myRecyclerAdapter=new MyRecyclerAdapter(this,pl,ld,ll); // instance of adapter class

        // Vertical layout
        recyclerView.setAdapter(myRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Horizontal layout
        recyclerViewHorizontal.setAdapter(myRecyclerAdapter);
        recyclerViewHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }

    private int[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.language_logo);
//        Drawable[] icons = new Drawable[ta.length()];
        int [] icons = new int[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
//            if (id != 0) {
////                icons[i] = ContextCompat.getDrawable(this, id);
//            }
            icons[i] = id;

        }
        ta.recycle();
        return icons;
    }
}
