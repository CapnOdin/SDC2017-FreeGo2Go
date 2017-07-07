package software.unf.dk.freego2go;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Scanner;

import static software.unf.dk.freego2go.R.layout.giriskerm;
import static software.unf.dk.freego2go.R.layout.menuskerm;


public class MainActivity extends AppCompatActivity {

    private Button ButtonStart, ButtonRules, ButtonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(menuskerm);

        ButtonStart = (Button) findViewById(R.id.StartButton);
        ButtonRules = (Button) findViewById(R.id.RulesButton);
        ButtonSettings = (Button) findViewById(R.id.SettingsButton);
    }

    public void startGame(View view) {
        //Intent intent = new Intent(this, giriskerm);
        //setC0ontentView(giriskerm);
        DialogFragment newFragment = new BoardSizeDialog(this);
        newFragment.show(getSupportFragmentManager(), "size");

    }

}