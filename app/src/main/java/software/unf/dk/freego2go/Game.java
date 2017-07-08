package software.unf.dk.freego2go;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static software.unf.dk.freego2go.R.layout.spilleskerm;

public class Game extends AppCompatActivity {
    TextView SwitchPlayerText, ScoreTextBlack, ScoreTextWhite, AmountOfTurns;
    GridView Coloumns;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(spilleskerm);
        Variables.Board = makeBoard();
        SwitchPlayerText = (TextView) findViewById(R.id.SwitchPlayer);
        ScoreTextBlack = (TextView) findViewById(R.id.ScoreTextBlack);
        ScoreTextWhite = (TextView) findViewById(R.id.ScoreTextWhite);
        AmountOfTurns = (TextView) findViewById(R.id.AmountOfTurns);
        Coloumns = (GridView) findViewById(R.id.Coloumns);

        Variables.amountOfTurns = 0;
        Variables.turn = true;
        playerTurn();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    // set board size
    public static void BoardSize() {

        ////System.out.println("Hvor stort skal brættet være?");
        //Scanner scan = new Scanner(System.in);
        //int n = scan.nextInt();
        Variables.boardsizeModifier = 9;

    }

    //Create Board
    public  ArrayList<ArrayList<Integer>> makeBoard() {
        //TODO: Add change boardModifierFunction
        GridView BoardLayOut = (GridView) findViewById(R.id.Coloumns);
        ArrayList<ArrayList<Integer
                >> Board = new ArrayList<>();

        //Adds expanding values to twodimensional array
        Integer[] lst = new Integer[Variables.boardsizeModifier * Variables.boardsizeModifier];
        for (int i = 0; i < Variables.boardsizeModifier; i++) {
            Board.add(new ArrayList<Integer>());
            for (int j = 0; j < Variables.boardsizeModifier; j++) {
                lst[i+j] = 0;
                Board.get(i).add(0);

            }

            //System.out.println(Board.get(i));
        }


        BoardLayOut.setAdapter(new GridAdapter(this));
        return Board;
    }

    public void playerTurn() {
        //Shows all relevant tex

        switchTurnText();
        ScoreTextBlack.setText("Black Score: " + Variables.amountOfBlack);
        ScoreTextWhite.setText("White Score: " + Variables.amountOfWhite);
        AmountOfTurns.setText("Amount of Turns: " + Variables.amountOfTurns);


        // Skifte turn og relavante variabler
        // User input til position på brættet
        if (Variables.turn) {
            // blacks turn
            //Spørg efter x eller pass
            ////System.out.println("B: Indtast koordinater x or pass");

            //Scanner scanx = new Scanner(System.in);
            String in = "5";
            //Check for string of int - Pass
            if (!in.equals("pass")) {
                Variables.currentX = 5;

                //Spørg efter y
                //System.out.println("B: Indtast koordinater y");
                //Scanner scany = new Scanner(System.in);
                Variables.currentY = 6;
                //Repeat if invalid move
//                while (!search.tileCheck(Variables.currentX, Variables.currentY)) {
//                    playerTurn();
//                }
            }


            Variables.amountOfTurns++;
            //TODO IF-STATEMENTS SOM ÆNDRER POINTVARIABLER

        } else {
            // Whites turn
            //Spørg efter x eller pass
            //System.out.println("W: Indtast koordinater x eller pass");

            //Scanner scanx = new Scanner(System.in);
            String in = "2";
            //Check for string of int - Pass
            if (!in.equals("pass")) {
                Variables.currentX = 7;

                //Spørg efter y
                //System.out.println("W: Indtast koordinater y");
                //Scanner scany = new Scanner(System.in);
                Variables.currentY = 7;
                //Repeat if invalid move
//                while (!search.tileCheck(Variables.currentX, Variables.currentY)) {
//                    playerTurn();
//                }
            }


            Variables.amountOfTurns++;
            //TODO IF-STATEMENTS SOM ÆNDRER POINTVARIABLER

        }
        //System.out.println(Variables.Board);

        //Skift spiller efter turslut
        Variables.turn = !Variables.turn;
        ////System.out.println("\nAmount of Turns: " + Variables.amountOfTurns);
    }

    public void switchTurnText() {

        if (Variables.turn)
            SwitchPlayerText.setText("Black's turn");
        else
            SwitchPlayerText.setText("White's turn");
    }

    public void StopGame(View view) {
        DialogFragment newFragment = new StopDialog(this);
        newFragment.show(getSupportFragmentManager(), "");

    }

    public void pass(View view){
        Variables.turn = !Variables.turn;
        Variables.amountOfTurns++;
        switchTurnText();

    }

    public static int setColumns(){
        return Variables.boardsizeModifier;
    }
}