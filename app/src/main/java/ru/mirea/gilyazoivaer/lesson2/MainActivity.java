package ru.mirea.gilyazoivaer.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private String TAG=MainActivity.class.getSimpleName().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
        editText=findViewById(R.id.editTextTextPersonName);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }
    @Override
    protected void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String text=savedInstanceState.getString("data_key");
        Log.d(TAG,"Saved Text" + text);
        if (text!=null)
            editText.setText(text);
    }
    @Override
    protected  void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
    @Override
    protected void  onSaveInstanceState(@NotNull Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG,"onSaveInstanceState method"+editText.getText().toString());
        savedInstanceState.putString("data_key",editText.getText().toString());
    }

    public void goToSecondActivity(View view) {
        Intent intent=new Intent(this,SecondActivity.class);
        intent.putExtra("key",editText.getText().toString());
        startActivity(intent);
    }
}