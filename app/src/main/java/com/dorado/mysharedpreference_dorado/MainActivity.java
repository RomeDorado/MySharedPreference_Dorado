package com.dorado.mysharedpreference_dorado;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_userName, et_password;
    Button btn_save, btn_display;
    TextView tv_display;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_userName = (EditText) findViewById(R.id.et_userName);
        et_password = (EditText) findViewById(R.id.et_Password);
        btn_save = (Button) findViewById(R.id.btnSave);
        btn_display = (Button) findViewById(R.id.btnDisplay);
        tv_display = (TextView) findViewById(R.id.tv_display);
        preferences = getPreferences(Context.MODE_PRIVATE);

    }

    public void saveInfo(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user", et_userName.getText().toString());
        editor.putString("pwd", et_password.getText().toString());
        editor.commit();

        Toast.makeText(this, "Saved in Preferences!", Toast.LENGTH_LONG).show();


    }

    public void displayInfo(View view){
        String user = preferences.getString("user", "");
        String pwd = preferences.getString("pwd", "");
        tv_display.setText("User is " + user + " and the password is " + pwd);
    }

}
