package com.akash2099.designapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_3 extends Fragment {

    public Fragment_3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_3, container, false);

        final Button start_home = view.findViewById(R.id.start_home);
        start_home.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent=new Intent(getContext(),HomeActivity.class);
                startActivity(intent);
//                Toast.makeText(v.getContext(), "Congrats !", Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }
}
