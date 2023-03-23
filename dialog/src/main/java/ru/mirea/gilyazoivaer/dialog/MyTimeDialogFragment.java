package ru.mirea.gilyazoivaer.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

public class MyTimeDialogFragment extends DialogFragment {
    Calendar dateAndTime=Calendar.getInstance();
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Изменение времени")
                .setMessage("Текущее время" +" "+ dateAndTime.get(Calendar.HOUR_OF_DAY)+":"+ dateAndTime.get(Calendar.MINUTE))
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Поменять время", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((MainActivity) getActivity()).onOkClickedTime();
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}
