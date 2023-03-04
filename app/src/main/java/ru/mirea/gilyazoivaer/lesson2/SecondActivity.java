package ru.mirea.gilyazoivaer.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acvtivity);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String value = extras.getString("key");
            Log.d(SecondActivity.class.getSimpleName(),"onCreateSecond " + value);
        }
    }
}