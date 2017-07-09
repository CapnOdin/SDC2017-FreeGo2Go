package software.unf.dk.freego2go;

import java.util.ArrayList;


public class Variables {

    //Menu skærm

    //Giri skærm
    public static int generatedNumber;

    //Board Skærm
    public static boolean turn = false;// true equals black and false equals white
    public static boolean oddOrEven;
    public static int boardsizeModifier = 13;
    public static int amountOfWhite = 0;
    public static int amountOfBlack = 0;
    public static int amountOfTurns = 0;
    public static int pointsOfWhite = 0;
    public static int pointsOfBlack = 0;
    public static int tilesLaidBlack = 0;
    public static int tilesLaidWhite = 0; //Husk at indsætte tælle op
    public static int currentX;
    public static int currentY;

    public static ArrayList<ArrayList<Integer>> Board;

    //Board logic
    public static boolean centerCheck;
    public static boolean leftCheck;
    public static boolean rightCheck;
    public static boolean topCheck;
    public static boolean bottomCheck;


}


