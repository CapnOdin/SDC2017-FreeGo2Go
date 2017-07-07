package software.unf.dk.freego2go;

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
    }

    //Vælger random tal, hvis inputtet svarer til vores generede tal så starter spilleren (ulige/lige)
    protected static void nigiri(boolean userInput) {
        //Skal op i onCreate for OddEvenSkærm
        int number = 1 + (int) (Math.random() * 50);
        System.out.println(number);


        if (Variables.generatedNumber % 2 == 0) {
            /*System.out.println("Odd=1 or even=2?");
            Scanner start = new Scanner(System.in);
            int n = start.nextInt();*/
            if (userInput) {
                Variables.turn = false; //set black
                //System.out.println("you got b");
            } else {
                Variables.turn = true; //set white
                //System.out.println("you got w");
            }

        } else {
            /*System.out.println("Odd=1 or even=2?");
            Scanner start = new Scanner(System.in);
            int n = start.nextInt();*/
            if (!userInput) {
                Variables.turn = true; //set white
                /*System.out.println("you got w");*/

            } else {
                Variables.turn = false; //set black
                /*System.out.println("you got b");*/
            }
        }
    }
    }

    public void ChooseOdd(View view) {
        nigiri();

    }

    public void ChooseEven(View view) {

    }


}
