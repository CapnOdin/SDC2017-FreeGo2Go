package software.unf.dk.freego2go;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nigiri();


    }

    //Nigiri Colorselection()
    protected void nigiri(){
        double number = Math.random();
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
