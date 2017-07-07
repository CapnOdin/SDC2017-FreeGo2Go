package software.unf.dk.freego2go;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

import static software.unf.dk.freego2go.R.layout.spilleskerm;

public class Spil extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(spilleskerm);
    }

    // set board size
    public static void BoardSize() {

        ////System.out.println("Hvor stort skal brættet være?");
        //Scanner scan = new Scanner(System.in);
        //int n = scan.nextInt();
        Variables.boardsizeModifier = 9;

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
            //System.out.println(Board.get(i));
        }
        return Board;
    }

    public static void playerTurn() {
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
                while (!search.tileCheck(Variables.currentX, Variables.currentY)) {
                    playerTurn();
                }
            }


            Variables.amountOfTurns++;
            //TODO IF-STATEMENTS SOM ÆNDRER POINTVARIABLER

        }
        //System.out.println(Variables.Board);

        //Skift spiller efter turslut
        Variables.turn = !Variables.turn;
        ////System.out.println("\nAmount of Turns: " + Variables.amountOfTurns);
    }

}
