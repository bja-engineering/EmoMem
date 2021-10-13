package com.example.alex.emomem;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class AlertDialogAbout extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //builder.setMessage("EmoMem v0.1\n\nEmoji icons provided free by EmojiOne\n\nOriginal design 'Proxemo' by Stephan Huber\n\n(C) Alexander Bejan")
        builder.setMessage("EmoMem v0.1\n\nEmoji icons provided free by EmojiOne\n\nOriginal design 'Proxemo' by Stephan Huber")

                .setNegativeButton("go back", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
