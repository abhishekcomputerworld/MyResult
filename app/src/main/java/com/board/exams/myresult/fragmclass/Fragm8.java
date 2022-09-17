package com.board.exams.myresult.fragmclass;


import android.content.Intent;
import android.os.Bundle;
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
public class Fragm8 extends Fragment {
    String []t8=new String[]{"8th Board Result ","DateSheet/TimeTable","Open school Result","Open School DateSheet"};

    String[]bt8=new String[]{
            "Himachal Pradesh","Rajasthan"
    };
    String[]boad=new String[]{
            "Tamilnadu Open School"
    };
    public Fragm8() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext(), R.layout.samp2frag,R.id.text2,t8);
        View v= inflater.inflate(R.layout.fragment_bfragm1, container, false);

        ListView listView=(ListView)v.findViewById(R.id.lisyview2);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), Result.class);

                intent.putExtra("class", "8r");
                if (position == 0 || position == 1) {
                    intent.putExtra("text", bt8);
                    intent.putExtra("name", t8[position]);
                    intent.putExtra("num", position);
                    startActivity(intent);
                }

                else  if (position == 2|| position == 3) {
                    intent.putExtra("text", boad);
                    intent.putExtra("name",  t8[position]);
                    intent.putExtra("num", position);
                    startActivity(intent);
                }

            }
        });
        return v;
    }

}
