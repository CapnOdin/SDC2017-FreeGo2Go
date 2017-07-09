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
        /* Unconventional App Description Placement

        Now you can play the legendary, 3000-year old game of "Go" on your very own device. Go on a
        magical journey into the mind of chinese people where everything is seen black and white, and
        tiles are covered by the minute.

        Features include:

       -  Bugs
       -  Local Multiplayer Game of "Go"
       -  No Computer player; Play with Friends!
       -  A ruleset that you can kind of follow
         */


        ButtonStart = (Button) findViewById(R.id.StartButton);
        ButtonRules = (Button) findViewById(R.id.RulesButton);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, Giri.class);
        startActivity(intent);
    }

    public void rules(View view) {
        Intent intent = new Intent(this, Rules.class);
        startActivity(intent);
    }
}