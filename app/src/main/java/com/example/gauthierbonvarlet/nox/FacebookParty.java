package com.example.gauthierbonvarlet.nox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by martinkoling on 2018-02-03.
 */

public class FacebookParty extends Activity {


    ListView list;


    Integer[] imgid={
            R.drawable.guestlist,
            R.drawable.moneypool,
            R.drawable.playlist,
            R.drawable.chat,
            R.drawable.byot,
            R.drawable.schedule,
            R.drawable.hire
    };

    String[] itemname ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player"
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facebook_party);

        CustomList adapter=new CustomList(this, itemname, imgid);
        list=(ListView)findViewById(R.id.faceView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                //String Slecteditem= itemname[+position];
                //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                if (position == 0) {

                Intent intent = new Intent(FacebookParty.this, ListOfFriends.class);
                startActivity(intent);

            }  else if (position == 5) {

                    Intent intent = new Intent(FacebookParty.this, ScheduleView.class);
                    startActivity(intent);

                } else if (position == 4) {

                    Intent intent = new Intent(FacebookParty.this, ItemView.class);
                    startActivity(intent);

                }

                else if(position == 1){
                    Intent intent = new Intent(FacebookParty.this, MoneyView.class);
                    startActivity(intent);


                }

                else if(position == 6){
                    Intent intent = new Intent(FacebookParty.this, HireView.class);
                    startActivity(intent);

                }

                else if(position == 2){
                    Intent intent = new Intent(FacebookParty.this, PlaylistView.class);
                    startActivity(intent);

                }



            }
        });

    }





}

