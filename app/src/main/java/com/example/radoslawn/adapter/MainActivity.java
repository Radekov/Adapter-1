package com.example.radoslawn.adapter;

import android.app.ListActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends ListActivity {
    //List<String> s = null;
    //List<Integer> s2 = null;
    private static final Integer[] ID_OF_PICTURES = {R.drawable.a0,R.drawable.a1,
            R.drawable.a2,R.drawable.a3,R.drawable.a4,R.drawable.a5,R.drawable.a6};

    List<Model> lista = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        lista = new ArrayList<Model>();
        byte[] array1  = new byte[10];
        byte[] array2  = new byte[25];

        for(Character i='A';i<'Z';i++){
            lista.add(new Model(i));
            for(int j=0;j<100;j++){
                new Random().nextBytes(array1);
                String genRandomString1 = new String(array1, Charset.forName("UTF-8"));
                genRandomString1 = i + genRandomString1;

                new Random().nextBytes(array2);
                String genRandomString2 = new String(array2, Charset.forName("UTF-8"));

                lista.add(new Model(ID_OF_PICTURES[j%7],genRandomString1,genRandomString2));
            }
        }
        /*
        s = new ArrayList<String>();
        for (int i = 0; i < 7; i++) {
            s.add("Obrazek #" + i);
        }
        s2 = new ArrayList<Integer>();
        for(int i = 0; i <s.size();i++){
            s2.add(i);
        }
        for(int i = 0; i<ID_OF_PICTURES.length;i++){
            if(i%3==0){
            }
            lista.add(new Model(ID_OF_PICTURES[i],"Obrazek #"+i,"Opis dla obrazka #"+i));
        }*/
        //setListAdapter(new IconAdapter());

        setListAdapter(new CzwartyAdapter());
    }
    class CzwartyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return lista.size();
        }

        @Override
        public Object getItem(int i) {
            return lista.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(getItemViewType(i) == 0){
                return getHeader(i,view,viewGroup);
            }

            View row = view;
            if(row==null){
                Log.e("View row","null");
                row=getLayoutInflater().inflate(R.layout.activity_main,viewGroup,false);
            }
            ViewHolder holder = (ViewHolder)row.getTag();
            if(holder == null){
                Log.e("Holder empty","null");
                holder = new ViewHolder(row);
                row.setTag(holder);
            }
            holder.iv.setImageResource(lista.get(i).getImg_id());
            holder.tv1.setText(lista.get(i).getTitle());
            holder.tv2.setText(lista.get(i).getDiscribe());

            return row;
        }
        View getHeader(int i, View view, ViewGroup viewGroup){
            View head = view;
            if(head == null){
                Log.e("Head is null", "null");
                head = getLayoutInflater().inflate(R.layout.activity_inne,viewGroup,false);
            }
            TextView tv = (TextView)head.findViewById(R.id.drugie);
            tv.setTypeface(null, Typeface.BOLD_ITALIC);
            //System.out.println(lista.get(i).getFirstLetter().toString());
            tv.setText(lista.get(i).getFirstLetter().toString());
            return head;
        }
        @Override
        public int getItemViewType(int position) {
            if(lista.get(position).getFirstLetter() != null)
                return 0;
            return 1;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.inne:
                startActivity(new Intent(this, InneActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
*/
/*
    class TrzeciAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return lista.size();
        }

        @Override
        public Object getItem(int i) {
            return lista.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(getItemViewType(i)==0){
                return getHead(i,view,viewGroup);
            }
            //Log.e("Zwykly","k");
            View row = view;
            if(row == null){
                row=getLayoutInflater().inflate(R.layout.activity_main,viewGroup,false);

            }
            ViewHolder holder = (ViewHolder)row.getTag();
            if (holder == null) {
                holder=new ViewHolder(row);
                row.setTag(holder);
            }
            holder.iv.setImageResource(((Model)lista.get(i)).getImg_id());
            holder.tv1.setText(((Model)lista.get(i)).getS1());
            holder.tv2.setText(((Model)lista.get(i)).getS2());

            return row;
        }
        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            //if(lista.get(position) instanceof Integer){
              //  return 0;
            //}
            return 1;
        }
        View getHead(int i, View view, ViewGroup viewGroup){
            View row = view;
            if(row == null){
                row=getLayoutInflater().inflate(R.layout.activity_inne,viewGroup,false);
            }
            TextView tv = (TextView)row.findViewById(R.id.drugie);
            tv.setText("Nagl #"+((Integer)lista.get(i)).toString());
            return row;
        }
    }
*/
/*
    class IconAdapter extends ArrayAdapter<String> {
        IconAdapter() {
            super(MainActivity.this, R.layout.activity_main, R.id.tekst1, s);
        }


        @Override
        public View getView(int position, View convertView,
                            ViewGroup parent) {

            if (getItemViewType(position) == 0) {
                return getInneCos(position, convertView, parent);
            }
            View r = super.getView(position, convertView, parent);

            ImageView iv = (ImageView) r.findViewById(R.id.icon);
            iv.setImageResource(R.drawable.a0 + position);


            TextView si = (TextView) r.findViewById(R.id.tekst2);
            si.setTextColor(Color.parseColor("#FF0000"));
            si.setText("sadaBaba");

            TextView si2 = (TextView) r.findViewById(R.id.tekst3);
            si2.setText("Opis dla obrazka #" + position);
            si2.setTextColor(Color.parseColor("#00FF00"));

            si = (TextView) r.findViewById(R.id.tekst1);
            si.setTextColor(Color.parseColor("#0000FF"));

            return (r);
        }

        public View getInneCos(int position, View convertView,
                               ViewGroup parent) {
            View r = convertView;
            if (r == null) {
                r = getLayoutInflater().inflate(R.layout.activity_inne, parent, false);
            }
            TextView tv = (TextView) findViewById(R.id.inne);
            tv.setText("#"+position);
            return (r);
        }

        @Override
        public int getItemViewType(int position) {
            return position%5==0?0:1;
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }
    }
*/

}
