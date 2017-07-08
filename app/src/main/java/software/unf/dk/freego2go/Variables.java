package software.unf.dk.freego2go;

import java.util.ArrayList;


public class Variables {

    //Menu skærm

    //Giri skærm
    public static int generatedNumber;

    //Board Skærm
    public static boolean turn = true;// true equals black and false equals white
    public static int boardsizeModifier = 13;
    public static int amountOfWhite = 0;
    public static int amountOfBlack = 0;
    public static int amountOfTurns = 0;
    public static int pointsOfWhite = 0;
    public static int pointsOfBlack = 0;
    public static int currentX;
    public static int currentY;
    public static ArrayList<ArrayList<Integer>> Board;
    public static ArrayList<String> sizeArray = new ArrayList<>();

}


