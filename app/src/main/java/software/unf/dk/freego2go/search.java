package software.unf.dk.freego2go;

/**
 * Created by deltager on 07-07-17.
 */

public class search {
    public static boolean tileCheck(int x, int y) {
        //Black
        if (Variables.turn) {
            //Check and Change States
            int ournum = Variables.Board.get(x).get(y);
            if (ournum == state.empty) {
                Variables.Board.get(x).set(y, state.black);
                //Return ift. While-loop
                return true;
            } else {
                System.out.println("Invalid Move");
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
}
