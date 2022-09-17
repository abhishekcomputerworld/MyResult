package com.board.exams.myresult.browserr;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatCheckBox;


import com.board.exams.myresult.R;

import java.util.ArrayList;

public class PopupAdapter extends ArrayAdapter<String> {

    Context context;
    private ArrayList<String> popupitem;
    enable_sc_shot enable_sc_shot;

    public PopupAdapter(Context c, ArrayList<String> options,enable_sc_shot enable_sc_sho) {
        super(c, R.layout.web_popup,R.id.qa,options);
        // super(c, R.layout.web_popup);
        this.context=c;
        this.popupitem = options;
   enable_sc_shot=enable_sc_sho; }
    class Myviewholder {
        private View b;
        private TextView c;
        private ProgressBar d;
        private AppCompatCheckBox e;

        Myviewholder(View v) { b = v.findViewById(R.id.q8);
            d = (ProgressBar) v.findViewById(R.id.qb);
            c = (TextView) v.findViewById(R.id.qa);
            e = (AppCompatCheckBox) v.findViewById(R.id.q7);
        }
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Myviewholder myviewholder=null;
        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);          //  View rowView=inflater.inflate(R.layout.samp1, null);
            convertView=inflater.inflate(R.layout.web_popup, parent, false);
            myviewholder=new Myviewholder(convertView);
            convertView.setTag(myviewholder);}
        else
            myviewholder=(Myviewholder) convertView.getTag();

        if (position == getCount()-1) {
            chekbox(myviewholder , convertView);
            final Myviewholder finalMyviewholder = myviewholder;
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(!new SearchEngineModal(context).block_add()){
                        finalMyviewholder.e.setChecked(true);
                        new SearchEngineModal(context). start_block_add(true);

                    }
                    else{
                        finalMyviewholder.e.setChecked(false);
                        new SearchEngineModal(context). start_block_add(false);

                    }
                }
            });
        }
        if (position == getCount()-2) {
            chekbox2(myviewholder , convertView);
            final Myviewholder finalMyviewholder = myviewholder;
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(!new SearchEngineModal(context).enable_Snap_Shot()){
                        finalMyviewholder.e.setChecked(true);
                        new SearchEngineModal(context). start_Take_Snap_Shot(true);
                        enable_sc_shot.enable_shot();

                    }
                    else{
                        finalMyviewholder.e.setChecked(false);
                        new SearchEngineModal(context). start_Take_Snap_Shot(false);
                        enable_sc_shot.enable_shot();
                    }
                }
            });
        }
       else {
            myviewholder.c.setText( popupitem.get(position));}
        return convertView;
    }





    private void chekbox(Myviewholder myviewholder, View convertView) {
    //    Toast.makeText(context, String.valueOf(new SearchEngineModal(context).block_add()), Toast.LENGTH_SHORT).show();
        myviewholder.e.setVisibility(View.VISIBLE);
        myviewholder.c.setText( "Block Ads on Web");
        myviewholder.e.setChecked(new SearchEngineModal(context).block_add());
        myviewholder.e.setOnCheckedChangeListener(null);

    }
    private void chekbox2(Myviewholder myviewholder, View convertView) {
       // Toast.makeText(context, String.valueOf(new SearchEngineModal(context).enable_Snap_Shot()), Toast.LENGTH_SHORT).show();

        myviewholder.e.setVisibility(View.VISIBLE);
        myviewholder.c.setText( "Take Snap_Shot");
        myviewholder.e.setChecked(new SearchEngineModal(context).enable_Snap_Shot());
        myviewholder.e.setOnCheckedChangeListener(null);

    }

}
/**
 //super(c, R.layout.web_popup,R.id.qa,options);

 class Adapters extends ArrayAdapter<String> {

 Context context;
 String []ti;
 String []sti;
 String []st2;

 public Adapters(Context c, String []t1,String []t2,String []t3) {
 super(c, R.layout.sam1,R.id.title,t1);
 this.context=c;
 this.ti=t1;
 this.sti=t2;
 this.st2=t3;
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
 public View getView(final int position, View convertView, ViewGroup parent) {
 Myviewholder myviewholder=null;
 if(convertView==null){ LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);          //  View rowView=inflater.inflate(R.layout.samp1, null);
 convertView=inflater.inflate(R.layout.sam1, parent, false);
 myviewholder=new Myviewholder(convertView);
 convertView.setTag(myviewholder);}
 else
 myviewholder=(Myviewholder) convertView.getTag();

 myviewholder.textView1.setText(ti[position]);
 myviewholder.textView2.setText(sti[position]);

 return convertView;
 }
 }




 **/