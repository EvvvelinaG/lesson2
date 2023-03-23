package ru.mirea.gilyazoivaer.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    Calendar dateAndTime=Calendar.getInstance();
    TextView textDateTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textDateTime=findViewById(R.id.dateTime);
        setInitialDateTime();
    }
    public void onClickShowDialog(View view) {
        MyDialogFragment dialogFragment = new MyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }
    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                        Toast.LENGTH_LONG).show();
    }

    public void onClickChangeTime(View view) {
        MyTimeDialogFragment timeDialogFragment = new MyTimeDialogFragment();
        timeDialogFragment.show(getSupportFragmentManager(), "mirea");
    }
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }};
    public void onOkClickedTime() {
        new TimePickerDialog(MainActivity.this, t,
            dateAndTime.get(Calendar.HOUR_OF_DAY),
            dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }

    public void onClickShowProgress(View view) {
        // create snackbar
        Snackbar s = Snackbar.make(view, "Show progress", Snackbar.LENGTH_LONG);
        s.setAction("Show", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyProgressDialogFragment dia = new MyProgressDialogFragment(MainActivity.this);
            }
        });
        s.show();
    }
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };
    public void onOkClickedDate() {
        new DatePickerDialog(MainActivity.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }
    private void setInitialDateTime() {

        textDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
    }
    public void onClickChangeDate(View view) {
        MyDateDialogFragment dateDialogFragment = new MyDateDialogFragment();
        dateDialogFragment.show(getSupportFragmentManager(), "mirea");
    }

}