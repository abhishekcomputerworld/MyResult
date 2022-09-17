package com.board.exams.myresult.fragmclass;


import android.content.Context;
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



import java.util.ArrayList;
import java.util.List;

/**
 */
public class Fragm2 extends Fragment {

   public String[][] boad;
   public   String []bod=new String[]{"12th Board Result","DateSheet/TimeTable ",
       "Sample Paper"   ,"Open school Result","Open School DateSheet","Syllabus"};

    public Fragm2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_bfragm1, container, false);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getContext(), R.layout.samp2frag,R.id.text2,bod);


        boad = new String[6][];
        // but  1,2
        boad[0] = new String[]{"CBSE","CISCE,ISC,ICSE","Andhra Pradesh", "Arunachal Pradesh","Assam","Bihar",
                "CGBSE / Chhattisgarh","Goa","Gujarat","HBSE,Haryana", "Himachal Pradesh",
                "Jammu and Kashmir","Jharkhand",
                "Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya",
                "Mizoram","Nagaland","NIOS","Odisha","Punjab",
                "Rajasthan","RSOS","Sikkim","Tamil Nadu",
                "Telangana","Tripura","Uttarakhand/ Uttranchal","Uttar Pradesh","West Bengal"
        };
        boad[1] = boad[0];
       //sample paper but 3,4
        boad[2] = new String[]{"CBSE","CISCE,ISC,ICSE","Andhra Pradesh","Assam","Bihar",
                "CGBSE / Chhattisgarh","Goa","Gujarat","HBSE,Haryana", "Himachal Pradesh",
                "Jharkhand",
                "Karnataka","Kerala","Madhya Pradesh","Maharashtra","Meghalaya","NIOS",     "Odisha","Punjab",
                "Rajasthan","Tamil Nadu",
                "Telangana","Uttarakhand/ Uttranchal","Uttar Pradesh",
        };

        //open school result  but 5,6
        boad[3] = new String[]{"Andhra Pradesh Open School","Assam Open School","Bihar Open School",
                "Chhattisgarh Open School","Gujarat Open School","Haryana Open School", "Himachal Pradesh Open School",
                "Jammu and Kashmir Open School","Jharkhand Open School",
                "Karnataka Open School","Kerala Open School","Madhya Pradesh Open School",
                "Nagaland Open School","NIOS Open School",     "Odisha Open School",
                "RSOS Open School","Tamil Nadu Open School",
                "Telangana Open School","Uttar Pradesh Open School","West Bengal Open School"
        };//20
        boad[4] = boad[3];

        //syllabus but 7
        boad[5] = new String[]{"CBSE","Andhra Pradesh","Assam","Bihar",
                "CGBSE / Chhattisgarh","CISCE,ISC,ICSE","Gujarat","HBSE,Haryana", "Himachal Pradesh",

                "Karnataka","Madhya Pradesh","Maharashtra","Meghalaya","Manipur","Mizoram","Nagaland","NIOS",     "Odisha","Punjab",
                "Rajasthan","Tamil Nadu",
                "Telengana",   "Tripura","Uttarakhand/ Uttranchal","Uttar Pradesh","West Bengal"
        };
        ListView listView=(ListView)v.findViewById(R.id.lisyview2);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int b=position;

                    Intent intent = new Intent(getActivity(), Result.class);
                    intent.putExtra("class", "12r");
                    intent.putExtra("text", boad[position]);

                    intent.putExtra("name", bod[position]);
                    intent.putExtra("num", position);

                    startActivity(intent);}



            });
        return v;
    }


}
