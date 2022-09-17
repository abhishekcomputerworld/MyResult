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

import androidx.fragment.app.Fragment;

import com.board.exams.myresult.R;
import com.board.exams.myresult.Result;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragm5 extends Fragment {

    String []t5=new String[]{"5th Board Result","DateSheet/TimeTable"};
    String[]bt5=new String[]{
            "Himachal Pradesh","Rajasthan"
    };

    public Fragm5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
             ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext(), R.layout.samp2frag,R.id.text2,t5
        );
        View v= inflater.inflate(R.layout.fragment_bfragm1, container, false);
        ListView listView=(ListView)v.findViewById(R.id.lisyview2);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                final int b=position;

                    Intent intent = new Intent(getActivity(), Result.class);
                    intent.putExtra("text", bt5);
                    intent.putExtra("class", "5r");

                    intent.putExtra("name", t5[position]);
                    intent.putExtra("num", position);
                    startActivity(intent);}

             });
        return v;
    }

}
