package software.unf.dk.freego2go;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Scanner;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nigiri();


    }

    //Nigiri Colorselection()
    //Vælger random tal, hvis inputtet svarer til vores generede tal så starter spilleren (ulige/lige)
    protected void nigiri(){
        int number = 1+ (int)(Math.random()*50);
        System.out.println(number);

        if(number % 2 == 0){
            System.out.println("Odd=1 or even=2?");
            Scanner start = new Scanner(System.in);
            int n = start.nextInt();
            if(n == 2) {
                Variables.turn = false; //set black
                System.out.println("you got b");
            }
            else {
                Variables.turn = true; //set white
                System.out.println("you got w");
            }

        }
        else {
            System.out.println("Odd=1 or even=2?");
            Scanner start = new Scanner(System.in);
            int n = start.nextInt();
            if(n == 2) {
                Variables.turn = true; //set white
                System.out.println("you got w");

            }
            else {
                Variables.turn = false; //set black
                System.out.println("you got b");
            }
        }
    }

    }

    //Board Generator()

    //Tile Search()

    //State Switch()


    /*Should have
     *
      * Scorecheck()
      *
      * Liberties()
      *
      * Capture Area Search()
      *
      * Hook up Graphics
      *
      * */
}
