package com.example.gauthierbonvarlet.nox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by martinkoling on 2018-02-04.
 */

public class MoneyView extends Activity implements android.text.TextWatcher{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.money_view);

        EditText txt1 = (EditText) findViewById(R.id.money);

       txt1.addTextChangedListener(this);


    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

        new CountDownTimer(1000, 1000) {


            @Override
            public void onTick(long l) {

            }

            public void onFinish() {
                Intent intent = new Intent(MoneyView.this, MoneyAfterView.class);
                startActivity(intent);
            }
        }.start();


    }
}

