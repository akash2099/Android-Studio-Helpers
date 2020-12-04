package com.akash2099.recyclerviewtutorial;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyviewHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    // class constructor
    public MyRecyclerAdapter(Context ct, String s1[], String s2[], int image[]){
        context=ct;
        data1=s1;
        data2=s2;
        images=image;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Step 1
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.row_recycler_view,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, final int position) {
        //Step 3
        // Access and set data dynamically
        holder.programming_title_textView.setText(data1[position]);
        holder.programming_description_textView.setText(data2[position]);
        holder.programming_logo_imageView.setImageResource(images[position]);

        // Set on click listener on dynamic rows
        holder.detailsConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,MoreDetailsActivity.class);
                intent.putExtra("data1",data1[position]);
                intent.putExtra("data2",data2[position]);
                intent.putExtra("myImage",images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        // Step 4
        return images.length;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{
        // Step 2
        TextView programming_title_textView,programming_description_textView;
        ImageView programming_logo_imageView;
        ConstraintLayout detailsConstraintLayout;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            programming_title_textView=itemView.findViewById(R.id.title_textView);
            programming_description_textView=itemView.findViewById(R.id.description_textView);
            programming_logo_imageView=itemView.findViewById(R.id.logo_imageview);

            detailsConstraintLayout= itemView.findViewById(R.id.mainDetailsLayout);
        }
    }
}
