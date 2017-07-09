package software.unf.dk.freego2go;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class Game extends AppCompatActivity {
    TextView SwitchPlayerText, ScoreTextBlack, ScoreTextWhite, AmountOfTurns, OddEven;
    GridView GridColumns;

    GridAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.spilleskerm);

        SwitchPlayerText = (TextView) findViewById(R.id.SwitchPlayer);
        ScoreTextBlack = (TextView) findViewById(R.id.ScoreTextBlack);
        ScoreTextWhite = (TextView) findViewById(R.id.ScoreTextWhite);
        OddEven = (TextView) findViewById(R.id.OddEvenText);
        AmountOfTurns = (TextView) findViewById(R.id.AmountOfTurns);
        GridColumns = (GridView) findViewById(R.id.Columns);

        Variables.amountOfTurns = 0;
        Variables.amountOfBlack = 0;
        Variables.amountOfWhite = 0;
        Variables.pointsOfBlack = 0;
        Variables.pointsOfWhite = 0;
        Variables.tilesLaidBlack = 0;
        Variables.tilesLaidWhite = 0;

        Variables.turn = true;
        Variables.Board = makeBoard();
        //playerTurn();
        startText();
        render();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    //Create Board
    public ArrayList<ArrayList<Integer>> makeBoard() {
        //TODO: Add change boardModifierFunction
        System.out.println(GridColumns + " " + Variables.boardsizeModifier);
        GridColumns.setNumColumns(Variables.boardsizeModifier);
        ArrayList<ArrayList<Integer>> Board = new ArrayList<>();

        //Adds expanding values to twodimensional array
        Integer[] lst = new Integer[Variables.boardsizeModifier * Variables.boardsizeModifier];
        for (int i = 0; i < Variables.boardsizeModifier; i++) {
            Board.add(new ArrayList<Integer>());
            for (int j = 0; j < Variables.boardsizeModifier; j++) {
                lst[i + j] = 0;
                Board.get(i).add(0);
            }
        }
        adapter = new GridAdapter(this);
        GridColumns.setAdapter(adapter);
        return Board;
    }

    public void startText() {
        if (Variables.oddOrEven) {
            OddEven.setText("Odd is Black");
        } else
            OddEven.setText("Even is Black");

    }

    public void playerTurn() {
        //Shows all relevant tex




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
                //Checkes if the last move made captures anything
                //search.captureArea();
            }

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


            //TODO IF-STATEMENTS SOM ÆNDRER POINTVARIABLER

        }
        //System.out.println(Variables.Board);

        //Skift spiller efter turslut
        Variables.turn = !Variables.turn;
        ////System.out.println("\nAmount of Turns: " + Variables.amountOfTurns);
    }

    public void kill(ArrayList<Point> previus) {
        for(Point p : previus) {
            if(Variables.Board.get(p.x).get(p.y) == state.black) {
                Variables.amountOfBlack--;
                Variables.pointsOfWhite++;
            } else if(Variables.Board.get(p.x).get(p.y) == state.white) {
                Variables.amountOfWhite--;
                Variables.pointsOfBlack++;
            }
            adapter.lst.get(p.x).get(p.y).setImageResource(R.drawable.neutral);
            Variables.Board.get(p.x).set(p.y, 0);
        }
        previus.clear();
        render();
    }

    public void switchTurn() {
        Variables.turn = !Variables.turn;
        Variables.amountOfTurns++;
        switchTurnText();
    }

    public void render() {
        switchTurnText();
        ScoreTextBlack.setText("Black Score: " + (Variables.amountOfBlack + Variables.pointsOfBlack));
        ScoreTextWhite.setText("White Score: " + (Variables.amountOfWhite + Variables.pointsOfWhite));
        AmountOfTurns.setText("Amount of Turns: " + Variables.amountOfTurns);
    }

    public void switchTurnText() {
        AmountOfTurns.setText("Amount of turns: " + Variables.amountOfTurns);
        if (Variables.turn)
            SwitchPlayerText.setText("Black's turn");
        else
            SwitchPlayerText.setText("White's turn");
    }

    public void StopGame(View view) {
        DialogFragment newFragment = new StopDialog(this);
        newFragment.show(getSupportFragmentManager(), "");
    }

    public void pass(View view) {
        Variables.turn = !Variables.turn;
        Variables.amountOfTurns++;
        switchTurnText();

    }

    public static int setColumns() {
        return Variables.boardsizeModifier;
    }

    //Skift spiller efter turslut
    public static void switchturn(){
        Variables.turn = !Variables.turn;
        System.out.println("\nAmount of Turns: " + Variables.amountOfTurns);
        System.out.println("\nW: " + Variables.amountOfWhite + ", B: " + Variables.amountOfBlack);
        //Reset tempBoard1
        search.maketempBoard();
    }
}
