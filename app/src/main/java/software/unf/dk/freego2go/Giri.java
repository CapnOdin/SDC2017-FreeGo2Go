package software.unf.dk.freego2go;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import static software.unf.dk.freego2go.R.layout.giriskerm;

public class Giri extends AppCompatActivity {

    Button ButtonEven, ButtonOdd, ButtonStart, ButtonRules;
    Spinner Spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(giriskerm);


        ButtonEven = (Button) findViewById(R.id.EvenButton);
        ButtonOdd = (Button) findViewById(R.id.OddButton);
        ButtonStart = (Button) findViewById(R.id.StartButton);
        ButtonRules = (Button) findViewById(R.id.RulesButton);
        Spin = (Spinner) findViewById(R.id.spinner);

        //Add to sizeArray
        ArrayList<String> sizeArray = new ArrayList<>();
        initArrayList(sizeArray);

        //Lav Spinner

        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sizeArray);
        s.setAdapter(adapter);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    //Vælger random tal, hvis inputtet svarer til vores generede tal så starter spilleren (ulige/lige)
    protected void nigiri(boolean userInput) {

        //Generer tilfældigt tal
        Variables.generatedNumber = 1 + (int) (Math.random() * 50);
        boolean generatedNumberBool;
        if (Variables.generatedNumber % 2 == 0) { //Generet tal EVEN
            generatedNumberBool = false;
            if (userInput == generatedNumberBool) { //Sammenligner bruger inputs og gør noget hvis de begger er EVEN
                Variables.turn = false;
                Variables.oddOrEven = false;
            } else{
                Variables.turn = true; //Hvis sammenligningen er ukorrekt så bliver det sat til white
                Variables.oddOrEven = true;
            }
        } else { //Generede tal = ODD
            generatedNumberBool = true;
            if (userInput == generatedNumberBool) {
                Variables.turn = false;
                Variables.oddOrEven = false;
            } else{
                Variables.turn = true;
                Variables.oddOrEven = true;
            }
        }
    }

    // set board size according to spinner
    public void BoardSize() {
        if (Spin.getSelectedItem() == "9x9 tiles") {
            Variables.boardsizeModifier = 9;
        } else if (Spin.getSelectedItem() == "13x13 tiles") {
            Variables.boardsizeModifier = 13;
        } else{
            Variables.boardsizeModifier = 19;
        }
    }

    //Adds elements to sizeArray / dropdown-menu
    public static void initArrayList(ArrayList<String> spinner) {
        spinner.add("9x9 tiles");
        spinner.add("13x13 tiles");
        spinner.add("19x19 tiles");
    }

    public void ChooseOdd(View view) {
        nigiri(true);
        BoardSize();
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);

    }

    public void ChooseEven(View view) {
        nigiri(false);
        BoardSize();
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);

    }


}
