package software.unf.dk.freego2go;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.DialogFragment;

public class StopDialog extends DialogFragment {

    Game d;

    public StopDialog(Game d) {
        super();
        this.d = d;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final Game context = this.d;
        builder.setMessage("Are you sure you want to stop the game, and does your opponent agree to you stopping the game?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(context, Win.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                })
        ;
        // Create the AlertDialog object and return it
        return builder.create();
    }


}
