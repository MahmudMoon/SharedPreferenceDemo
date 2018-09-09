package com.example.moon.sharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3;
    Button btn,btn2;
    SharedPreferences sharedPreferences;
    private static String myPref = "MySharedPref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText)findViewById(R.id.editText);
        et2 = (EditText)findViewById(R.id.editText2);
        et3 = (EditText)findViewById(R.id.editText3);
        btn = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn2.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences(myPref,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",et1.getText().toString().trim());
                editor.putString("phone",et2.getText().toString().trim());
                editor.putString("age",et3.getText().toString().trim());
                editor.apply();
                btn2.setVisibility(View.VISIBLE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences(myPref,MODE_PRIVATE);
                String Name = sharedPreferences.getString("name",null);
                String Phone = sharedPreferences.getString("phone",null);
                String Age = sharedPreferences.getString("age",null);

                Log.d("MESSAGE",Name+"\n"+Phone+"\n"+Age);
                btn2.setVisibility(View.INVISIBLE);


            }
        });



    }
}
