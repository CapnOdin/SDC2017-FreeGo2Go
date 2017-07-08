package software.unf.dk.freego2go;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public void startGame(View view) {
        //Intent intent = new Intent(this, giriskerm);
        //setContentView(giriskerm);
        DialogFragment newFragment = new BoardSizeDialog(this);
        newFragment.show(getSupportFragmentManager(), "size");

    }

    public void rules(View view) {
        Intent intent = new Intent(this, Rules.class);
        startActivity(intent);
    }
}