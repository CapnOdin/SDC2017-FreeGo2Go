package software.unf.dk.freego2go;

import java.util.ArrayList;



public class search {

    private static ArrayList<ArrayList<Integer>> tempBoard = (ArrayList<ArrayList<Integer>>) Variables.Board.clone(); //TODO: check if this
    // TODO: overwrite the orginal board, this might be why it only prints in the temp array

    public static ArrayList<ArrayList<Integer>> getTempBoard1() {
        return TempBoard1;
    }
    private static ArrayList<ArrayList<Integer>> TempBoard1 = maketempBoard();

    public static ArrayList<ArrayList<Integer>> maketempBoard() {

        ArrayList<ArrayList<Integer>> TempBoard2 = new ArrayList<>();
        for (int i = 0; i < Variables.boardsizeModifier; i++) {
            TempBoard2.add(new ArrayList<Integer>());
            for (int j = 0; j < Variables.boardsizeModifier; j++) {
                TempBoard2.get(i).add(0); //TODO: check if we need an empty element to add 6

            }

        }
        return TempBoard2;
    }





    public static boolean tileCheck(int x, int y) {
        //Black
        if (Variables.turn) {
            //Check and Change States
            int ournum = Variables.Board.get(x).get(y);
            if (ournum == state.empty) {
                Variables.Board.get(x).set(y, state.black);
                //Return ift. While-loop
                return true;
            }
            else{
                //System.out.println("Invalid Move");
                return false;
            }
        }

        //White
        if (!Variables.turn) {
            //Check and Change States
            int ournum = Variables.Board.get(x).get(y);
            if (ournum == state.empty) {
                Variables.Board.get(x).set(y, state.white);
                return true;
            } else {
                System.out.println("Invalid Move");
                return false;
            }
        }
        return Variables.turn;
    }


    //Searches values of tiles to change the value of captured areas
    public static void captureArea() {
        //Checking if the tiles around the last laid tile is empty, to know if we need to expand search

        int y1 = -1, x1 = -1;
        int y2 = 1, x2 = 1;

        //checks all four sides edges
        indexChecker();

        //if not an edge/checks all surroundings tiles


        if (Variables.leftCheck) {
            y1 = 0;
        }
        if (Variables.rightCheck) {
            y2 = 0;
        }
        if (Variables.topCheck) {
            x1 = 0;
        }
        if (Variables.bottomCheck) {
            x2 = 0;
        }

        for (int i = y1; i <= y2; i++) {

            for (int j = x1; j <= x2; j++) {
                //if not empty around
                if (Variables.turn && tempBoard.get(Variables.currentX + i).get(Variables.currentY + j) > 0) {

                    tempBoard.get(Variables.currentX).set(Variables.currentY, 0);
                    System.out.println();
                    //Check for simmilar stones
                    System.out.println(tempBoard.get(Variables.currentX + i).get(Variables.currentY + j));
                    if (tempBoard.get(Variables.currentX + i).get(Variables.currentY + j) == 1) {
                        System.out.println("hey");
                        //Adds state to temboard 2
                        TempBoard1.get(Variables.currentX).set(Variables.currentY, 6);

                        //Removes used values from origianl tempBoard
                        tempBoard.get(Variables.currentX).set(Variables.currentY, 0);



                        captureArea();

                    }
                }
                if (!Variables.turn && tempBoard.get(Variables.currentX + i).get(Variables.currentY + j) > 0) {


                    //Check for simmilar stones
                    if (tempBoard.get(Variables.currentX + i).get(Variables.currentY + j) == 2) {
                        System.out.println("hey");
                        //Adds state to temboard 2
                        TempBoard1.get(Variables.currentX).set(Variables.currentY, 6);

                        //Removes used values from origianl tempBoard
                        tempBoard.get(Variables.currentX).set(Variables.currentY, 0);


                        captureArea();

                    }
                }
            }

        }
        //TODO: move switchturn
        Variables.leftCheck = false;
        Variables.rightCheck = false;
        Variables.topCheck = false;
        Variables.bottomCheck = false;

    }

    //Sets GlobalCheck-variables
    public static void indexChecker() {


        if (Variables.currentY == Variables.boardsizeModifier) {
            Variables.rightCheck = true;

        }
        if (Variables.currentY == 0) {
            Variables.leftCheck = true;

        }
        if (Variables.currentX == Variables.boardsizeModifier) {
            Variables.bottomCheck = true;

        }
        if (Variables.currentX == 0) {
            Variables.topCheck = true;

        }


        if (!(Variables.leftCheck && Variables.rightCheck && Variables.bottomCheck && Variables.topCheck)) {
            Variables.centerCheck = true;
        }
    }
    public static boolean placeLegal(ArrayList<ArrayList<Integer>> board, ArrayList<Point> previousPoints, int turn, int x, int y) {
        if(board.get(x).get(y) != 0){
            return false;
        } else {
            return liberties(board, previousPoints, turn, x, y);
        }
    }

    public static boolean liberties(ArrayList<ArrayList<Integer>> board, ArrayList<Point> previousPoints, int state2, int x, int y) {
        previousPoints.add(new Point(x, y));
        return     checkArea(state2, x - 1, y, board, previousPoints)
                || checkArea(state2, x + 1, y, board, previousPoints)
                || checkArea(state2, x, y - 1, board, previousPoints)
                || checkArea(state2, x, y + 1, board, previousPoints);
    }

    public static boolean seenPreviously(ArrayList<Point> previousPoints, int x, int y, int state, int state1) {
        return !previousPoints.contains(new Point(x, y)) && state == state1;
    }

    public static boolean checkArea(int state2, int x, int y, ArrayList<ArrayList<Integer>> board, ArrayList<Point> previousPoints) {
        if (x >= 0 && y >= 0 && x < Variables.boardsizeModifier && y < Variables.boardsizeModifier) {
            if (seenPreviously(previousPoints, x, y, board.get(x).get(y), 0)) {
                return true;

            } else if (seenPreviously(previousPoints, x, y, board.get(x).get(y), state2)) {
                return liberties(board, previousPoints, state2, x, y);
            }
        }

        return (false);
    }


}
