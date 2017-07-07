package software.unf.dk.freego2go;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import java.util.ArrayList;
import java.util.Scanner;

import static software.unf.dk.freego2go.R.layout.giriskerm;
import static software.unf.dk.freego2go.R.layout.menuskerm;


public class MainActivity extends AppCompatActivity {

    private Button ButtonEven, ButtonOdd, ButtonStart, ButtonRules, ButtonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(menuskerm);


        ButtonEven = (Button) findViewById(R.id.EvenButton);
        ButtonOdd = (Button) findViewById(R.id.OddButton);
        ButtonStart = (Button) findViewById(R.id.StartButton);
        ButtonRules = (Button) findViewById(R.id.RulesButton);
        ButtonSettings = (Button) findViewById(R.id.SettingsButton);


        BoardSize();
        Variables.Board = makeBoard();

        //nigiri();

        while (true) {
            playerTurn();
        }

        //Vundet method


    }

    public void startGame(View view) {
        //Intent intent = new Intent(this, giriskerm);
        //setC0ontentView(giriskerm);
        DialogFragment newFragment = new BoardSizeDialog();
        newFragment.show(getSupportFragmentManager(), "size");

    }

    public void ChooseOdd(View view) {

    }

    public void ChooseEven(View view) {

    }


    //Chooses startplayer
    protected static void nigiri(boolean userInput) {
        /*Skal op i onCreate for OddEvenSkærm
        int number = 1 + (int) (Math.random() * 50);
        System.out.println(number);*/


        if (Variables.generatedNumber % 2 == 0) {

            if (userInput) {
                Variables.turn = false; //set black
                //Eventuelt notice/toast om at man har fået sort
                //TODO: TEXTVIEW THAT SHOWS WHOS TURN IT IS
            } else {
                Variables.turn = true; //set white

            }

        } else {

            if (!userInput) {
                Variables.turn = true; //set white
            } else {
                Variables.turn = false; //set black
            }
        }
    }

    // set board size
    public static void BoardSize() {

        System.out.println("Hvor stort skal brættet være?");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Variables.boardsizeModifier = n;

    }

    //Create Board
    public static ArrayList<ArrayList<Integer>> makeBoard() {
        //TODO: Add change boardModifierFunction
        ArrayList<ArrayList<Integer>> Board = new ArrayList<>();
        for (int i = 0; i < Variables.boardsizeModifier; i++) {
            Board.add(new ArrayList<Integer>());
            for (int j = 0; j < Variables.boardsizeModifier; j++) {
                Board.get(i).add(0);

            }
            System.out.println(Board.get(i));
        }
        return Board;
    }

    //Describes a players turn
    public static void playerTurn() {
        // Skifte turn og relavante variabler
        // User input til position på brættet
        if (Variables.turn) {
            // blacks turn
            //Spørg efter x eller pass
            System.out.println("B: Indtast koordinater x or pass");

            Scanner scanx = new Scanner(System.in);
            Variables.currentX = scanx.nextInt();

            //Spørg efter y
            System.out.println("B: Indtast koordinater y");
            Scanner scany = new Scanner(System.in);
            Variables.currentY = scany.nextInt();
            //Repeat if invalid move
            while (!search.tileCheck(Variables.currentX, Variables.currentY)) {
                playerTurn();
            }

            //Change Relevant Variables
            Variables.amountOfBlack++;
            Variables.amountOfTurns++;

        } else {
            // Whites turn
            //Spørg efter x eller pass
            System.out.println("W: Indtast koordinater x eller pass");

            Scanner scanx = new Scanner(System.in);
            Variables.currentX = scanx.nextInt();
            //Check for string of int - Pass

            //Spørg efter y
            System.out.println("W: Indtast koordinater y");
            Scanner scany = new Scanner(System.in);

            Variables.currentY = scany.nextInt();
            //Repeat if invalid move
            while (!search.tileCheck(Variables.currentX, Variables.currentY)) {
                playerTurn();
            }

            //Change Relevant Variables
            Variables.amountOfWhite++;
            Variables.amountOfTurns++;

        }
        System.out.println(Variables.Board);

        //Skift spiller efter turslut
        Variables.turn = !Variables.turn;
        System.out.println("\nAmount of Turns: " + Variables.amountOfTurns);
        System.out.println("\nW: " + Variables.amountOfWhite + ", B: " + Variables.amountOfBlack);
    }

    //Passes the turn
    public static void pass() {
        Variables.turn = !Variables.turn;
        Variables.amountOfTurns++;

    }

}