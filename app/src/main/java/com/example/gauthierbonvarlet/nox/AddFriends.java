package com.example.gauthierbonvarlet.nox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by martinkoling on 2018-02-04.
 */

public class AddFriends extends Activity {

    ListView list;
    String[] itemname ={
            "Safari",
            "Camera"
    };

    Integer[] imgid={

            R.drawable.inviteperson14,
            R.drawable.inviteperson2
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friend);
        Custom adapter=new Custom(this, itemname, imgid);
        list=(ListView)findViewById(R.id.addView);
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

    }


}





