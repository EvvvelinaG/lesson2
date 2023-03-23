package ru.mirea.gilyazoivaer.dialog;

import android.app.ProgressDialog;
import android.content.Context;

public class MyProgressDialogFragment {
    public MyProgressDialogFragment(Context context) {
        ProgressDialog dia = new ProgressDialog(context);
        dia.setTitle("Загрузка");
        dia.setMessage("Грузится...");
        dia.show();
    }
}
