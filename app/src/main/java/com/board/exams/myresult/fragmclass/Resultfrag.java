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
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.board.exams.myresult.FragMesult;
import com.board.exams.myresult.R;

/**
 */


public class Resultfrag extends Fragment {
    String []t11=new String[]{"CBSE","CISCE,ISC,ICSE","Andhra Pradesh", "Arunachal Pradesh","Assam","Bihar",
            "CGBSE / Chhattisgarh","Goa","Gujarat","HBSE,Haryana", "Himachal Pradesh",
            "Jammu and Kashmir","Jharkhand",
            "Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya",
            "Mizoram","Nagaland","NIOS","Odisha","Punjab",
            "Rajasthan","RSOS","Sikkim","Tamil Nadu",
            "Telangana","Tripura","Uttarakhand/ Uttranchal","Uttar Pradesh","West Bengal"
    };


    String[]bt11=new String[]{"Andhra Pradesh","Karnataka Board", "Meghalaya Board",
            "Nagaland", "Tamil Nadu", "Himachal Pradesh", "Telangana"
    };

    public Resultfrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>
                (getContext(), R.layout.samp2frag,R.id.text2,t11);

        View v= inflater.inflate(R.layout.fragment_bfragm1, container, false);
        ListView listView=(ListView)v.findViewById(R.id.lisyview2);
        listView.setAdapter(arrayAdapter);

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final int b=position;
        {
            Intent intent= new Intent(getActivity(), FragMesult.class);
            intent.putExtra("title",t11[position]);
            startActivity(intent);}
    }
});
        return v;
    }
    class Adapters extends ArrayAdapter<String> {

        Context context;
        String []ti;
        public Adapters(Context c, String []t1) {
            super(c, R.layout.sam1,R.id.title,t1);
            this.context=c;
            this.ti=t1;
        }

        class Myviewholder{
            TextView textView1;
            TextView textView2;

            public Myviewholder(View v) {
                textView1 = (TextView) v.findViewById(R.id.title);
                textView2 = (TextView) v.findViewById(R.id.subtitle);
            }




        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Myviewholder myviewholder=null;
            if(convertView==null){ LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);          //  View rowView=inflater.inflate(R.layout.samp1, null);
                convertView=inflater.inflate(R.layout.samp2frag, parent, false);
                myviewholder=new Myviewholder(convertView);
                convertView.setTag(myviewholder);}
            else
                myviewholder=(Myviewholder) convertView.getTag();

            myviewholder.textView1.setText(ti[position]);

            return convertView;
        }
    }

}
