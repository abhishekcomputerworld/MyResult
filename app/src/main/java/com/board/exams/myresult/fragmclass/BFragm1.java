package com.board.exams.myresult.fragmclass;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.board.exams.myresult.R;
import com.board.exams.myresult.Result;




public class BFragm1 extends Fragment {
    String []t11=new String[]{"11th Board Result","DateSheet/TimeTable"};
    String[]bt11=new String[]{"Andhra Pradesh","Karnataka Board", "Meghalaya Board",
            "Nagaland", "Tamil Nadu", "Himachal Pradesh", "Telangana"
    };

    public BFragm1() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
// add


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
           View v= inflater.inflate(R.layout.fragment_bfragm1, container, false);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext(), R.layout.samp2frag,R.id.text2,t11);
        ListView listView=(ListView)v.findViewById(R.id.lisyview2);
         listView.setAdapter(arrayAdapter);
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //add
                 final int b=position;

                     Intent intent = new Intent(getActivity(), Result.class);
                     intent.putExtra("text", bt11);
                     intent.putExtra("class", "11r");

                     intent.putExtra("name", t11[position]);
                     intent.putExtra("num", position);
                     startActivity(intent);}



         });
         return v;
    }

}
