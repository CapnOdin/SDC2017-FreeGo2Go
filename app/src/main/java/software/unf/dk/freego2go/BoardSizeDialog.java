package software.unf.dk.freego2go;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by deltager on 07-07-17.
 */

public class BoardSizeDialog extends DialogFragment {

    MainActivity d;

    public BoardSizeDialog(MainActivity d) {
        super();
        this.d = d;
    }

    @Override public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final MainActivity context = this.d;
        builder.setMessage("Vil du starte et spil?")
                .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(context, Giri.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Nej", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                })
        ;
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
