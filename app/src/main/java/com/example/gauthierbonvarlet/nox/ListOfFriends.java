package com.example.gauthierbonvarlet.nox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by martinkoling on 2018-02-03.
 */

public class ListOfFriends extends Activity {

    ListView list;
    String[] itemname ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "VLC Player",
            "VLC Player",
            "VLC Player",
            "VLC Player",
            "VLC Player",
            "VLC Player"
    };

    Integer[] imgid={
            R.drawable.person1,
            R.drawable.person15,
            R.drawable.person11,
            R.drawable.person4,
            R.drawable.person5,
            R.drawable.person6,
            R.drawable.person7,
            R.drawable.person8,
            R.drawable.person9,
            R.drawable.person10,
            R.drawable.person3,
            R.drawable.person12,
            R.drawable.person13

    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_of_friends);
        Custom adapter=new Custom(this, itemname, imgid);
        list=(ListView)findViewById(R.id.friendView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                //String Slecteditem= itemname[+position];
                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();



            }
        });

        Button btn = (Button)findViewById(R.id.button5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListOfFriends.this, AddFriends.class));
            }
        });

    }


    }





