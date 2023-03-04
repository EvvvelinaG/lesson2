package ru.mirea.gilyazoivaer.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Integer count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editTextTextPersonName);
    }

    public void countSymbols(View view) {
        count= editText.getText().toString().length();
        Toast toast = Toast.makeText(getApplicationContext(),"Студентка №5 группы БСБО-07-21 Кол-во символов " + count,Toast.LENGTH_LONG);
        toast.show();
    }
}