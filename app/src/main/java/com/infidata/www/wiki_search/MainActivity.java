package com.infidata.www.wiki_search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.EditText;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    List<String> bfs;

    ArrayAdapter<String> arrayAdapter;
    EditText editText;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);

        bfs=new ArrayList<String>();
        editText=findViewById(R.id.editText);


        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bfs);
        listView.setAdapter(arrayAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                Intent in = new Intent(getApplicationContext(), webSearch.class);
                in.putExtra("data", bfs.get(position));

                startActivity(in);
            }


            });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long id) {
                bfs.remove(pos);
                arrayAdapter.notifyDataSetChanged();

                return true;
            }
        });


    }


    public void add(View view) {
        String data=editText.getText().toString();
        bfs.add(data);
        arrayAdapter.notifyDataSetChanged();
        editText.setText("");
    }
}
