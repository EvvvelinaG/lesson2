package ru.mirea.gilyazoivaer.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class MyDateDialogFragment extends DialogFragment {
    Calendar dateAndTime=Calendar.getInstance();
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Изменение даты")
                .setMessage("Текущая дата" +" " + dateAndTime.get(Calendar.DAY_OF_MONTH)+"."+ dateAndTime.get(Calendar.MONTH)+"."+ dateAndTime.get(Calendar.YEAR))
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Поменять дату", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((MainActivity) getActivity()).onOkClickedDate();
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}
