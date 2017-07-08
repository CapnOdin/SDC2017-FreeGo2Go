package software.unf.dk.freego2go;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import static software.unf.dk.freego2go.R.layout.giriskerm;

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

        Game.BoardSize();

        //Add to sizeArray
        initArrayList();

        //Lav Spinner
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Variables.sizeArray);
        s.setAdapter(adapter);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    //Vælger random tal, hvis inputtet svarer til vores generede tal så starter spilleren (ulige/lige)
    protected void nigiri(boolean userInput) {

        //Generer tilfældigt tal
        Variables.generatedNumber = 1 + (int) (Math.random() * 50);

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

    //Adds elements to sizeArray / dropdown-menu
    public static void initArrayList() {
        Variables.sizeArray.add("9x9 tiles");
        Variables.sizeArray.add("13x13 tiles");
        Variables.sizeArray.add("19x19 tiles");
    }

    public void ChooseOdd(View view) {
        nigiri(true);
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);

    }

    public void ChooseEven(View view) {
        nigiri(false);
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);

    }


}
