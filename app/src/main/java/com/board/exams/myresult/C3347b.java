package com.board.exams.myresult;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/* renamed from: com.mpawer.tools.examresult.b */
public class C3347b extends ArrayAdapter<Object> {

    /* renamed from: b */
    private final Activity f16386b;

    /* renamed from: c */
    private final String[][] f16387c;

    /* renamed from: d */
    private final int[] f16388d;

    /* renamed from: com.mpawer.tools.examresult.b$a */
    static class C3348a {

        /* renamed from: a */
        public TextView f16389a;

        /* renamed from: b */
        public TextView f16390b;

        /* renamed from: c */
        public TextView f16391c;

        /* renamed from: d */
        public ImageView f16392d;

        C3348a() {
        }
    }

    public C3347b(Activity activity, String[][] strArr, int[] iArr) {
        super(activity, R.layout.apps_list_item, strArr);
        this.f16386b = activity;
        this.f16387c = strArr;
        this.f16388d = iArr;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f16386b.getLayoutInflater().inflate(R.layout.apps_list_item, (ViewGroup) null);
            C3348a aVar = new C3348a();
            aVar.f16389a = (TextView) view.findViewById(R.id.title);
            aVar.f16390b = (TextView) view.findViewById(R.id.subtitle);
            aVar.f16391c = (TextView) view.findViewById(R.id.latest);
            aVar.f16392d = (ImageView) view.findViewById(R.id.icon);
            view.setTag(aVar);
        }
        C3348a aVar2 = (C3348a) view.getTag();
        aVar2.f16389a.setText(this.f16387c[i][0]);
        if (this.f16387c[i][1].equals("")) {
            aVar2.f16390b.setVisibility(8);
        } else {
            aVar2.f16390b.setVisibility(0);
            aVar2.f16390b.setText(this.f16387c[i][1]);
        }
        if (this.f16387c[i][3].equals("")) {
            aVar2.f16391c.setVisibility(8);
        } else {
            aVar2.f16391c.setVisibility(0);
            aVar2.f16391c.setText(this.f16387c[i][3]);
        }
        if (this.f16388d == null) {
            aVar2.f16392d.setVisibility(8);
        } else {
            aVar2.f16392d.setVisibility(0);
            aVar2.f16392d.setImageResource(this.f16388d[i]);
        }
        return view;
    }
}
