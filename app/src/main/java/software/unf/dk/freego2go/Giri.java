package software.unf.dk.freego2go;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Scanner;

import static software.unf.dk.freego2go.Spil.BoardSize;
import static software.unf.dk.freego2go.R.layout.giriskerm;

/**
 * Created by deltager on 07-07-17.
 */

public class Giri extends AppCompatActivity {

    Button ButtonEven, ButtonOdd, ButtonStart, ButtonRules, ButtonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(giriskerm);


        ButtonEven = (Button) findViewById(R.id.EvenButton);
        ButtonOdd = (Button) findViewById(R.id.OddButton);
        ButtonStart = (Button) findViewById(R.id.StartButton);
        ButtonRules = (Button) findViewById(R.id.RulesButton);
        ButtonSettings = (Button) findViewById(R.id.SettingsButton);

        Spil.BoardSize();
        Variables.Board = Spil.makeBoard();

        //Generer tilfældigt tal
        Variables.generatedNumber = 1 + (int) (Math.random() * 50);

    }

    //Vælger random tal, hvis inputtet svarer til vores generede tal så starter spilleren (ulige/lige)
    protected static void nigiri(boolean userInput) {
        if (Variables.generatedNumber % 2 == 0) {
            if (userInput) {
                Variables.turn = false; //set black
            } else
                Variables.turn = true; //set white
        } else {
            if (!userInput) {
                Variables.turn = true; //set white
            } else
                Variables.turn = false; //set black
        }
    }


    public void ChooseOdd(View view) {
        nigiri(true);
        Intent intent = new Intent(this, Spil.class);
        startActivity(intent);

    }

    public void ChooseEven(View view) {
        nigiri(false);
        Intent intent = new Intent(this, Spil.class);
        startActivity(intent);

    }


}
