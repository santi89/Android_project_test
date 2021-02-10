package com.st.app1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatDialogFragment;

public class ExampleDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context;
        AlertDialog.Builder builder =new AlertDialog.Builder(getActivity()); // getactivity can change to MainActivity.java
         builder.setTitle("information")
                .setMessage("this is dialog")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }
                );return builder.create();
    }
}
