package software.unf.dk.freego2go;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static software.unf.dk.freego2go.R.layout.winskerm;

public class Win extends AppCompatActivity {
    TextView endScoreWhite, endScoreBlack, endTurns, winPlayer;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(winskerm);

        endScoreBlack = (TextView) findViewById(R.id.WinBlack);
        endScoreWhite = (TextView) findViewById(R.id.WinWhite);
        winPlayer = (TextView) findViewById(R.id.WinText);
        endTurns = (TextView) findViewById(R.id.WinTurns);

        endScoreWhite();
        endScoreBlack();
        winPlayer();
        endTurns();
    }

    public void endScoreWhite() {
        endScoreWhite.setText("White Score: " + (Variables.amountOfBlack + Variables.pointsOfBlack));
    }

    public void endScoreBlack() {
        endScoreBlack.setText("Black Score: " + (Variables.amountOfWhite + Variables.pointsOfWhite));

    }

    public void endTurns() {
         endTurns.setText("Amount of turns: " + Variables.amountOfTurns);
    }

    public void winPlayer() {
        if (Variables.pointsOfWhite > Variables.pointsOfBlack) {
            winPlayer.setText("White Wins");
        } else if (Variables.pointsOfWhite == Variables.pointsOfBlack) {
            winPlayer.setText("Draw");
        } else {
            winPlayer.setText("Black Wins");
        }
    }

    public void goToMenu(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
