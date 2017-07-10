package software.unf.dk.freego2go;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private Context mContext;

    public ArrayList<ArrayList<IndexedImageView>> lst;

    public GridAdapter(Context c) {
        mContext = c;
        lst = new ArrayList<>();
        for (int i = 0; i < Variables.boardsizeModifier; i++) {
            lst.add(new ArrayList<IndexedImageView>());
        }

    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        IndexedImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new IndexedImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
            imageView.setMinimumWidth(0);
            imageView.setAdjustViewBounds(true);
            imageView.j = position / Variables.boardsizeModifier;
            imageView.i = position % Variables.boardsizeModifier;
            lst.get(imageView.i).add(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {
                    int i = ((IndexedImageView) view).i;
                    int j = ((IndexedImageView) view).j;
                    boolean invalid = false;
                    if (Variables.Board.get(i).get(j) == state.empty) {
                        ArrayList<Point> previous = new ArrayList<Point>();
                        if (Variables.turn && search.placeLegal(Variables.Board, new ArrayList<Point>(), state.black, i, j)) {
                            ((ImageView) view).setImageResource(R.drawable.black);
                            Variables.Board.get(i).set(j, state.black);
                            Variables.amountOfBlack++;
                            kill(i, j, state.white);
                            ((Game) mContext).render();
                            ((Game) mContext).switchTurn();
                        } else if (!Variables.turn && search.placeLegal(Variables.Board, new ArrayList<Point>(), state.white, i, j)) {
                            ((ImageView) view).setImageResource(R.drawable.white);
                            Variables.Board.get(i).set(j, state.white);
                            Variables.amountOfWhite++;
                            kill(i, j, state.black);
                            ((Game) mContext).render();
                            ((Game) mContext).switchTurn();
                        } else {
                            invalid = true;
                        }
                    } else {
                        invalid = true;
                    }
                    if(invalid) {
                        Toast toast = Toast.makeText(mContext, "invalid move", Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            });
        } else {
            imageView = (IndexedImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = drawBoard(Variables.boardsizeModifier);

    private void kill(int i, int j, int state) {
        ArrayList<Point> previous = new ArrayList<Point>();
        System.out.println(i + ", " + j);
        if(onBoard(i - 1, j) && Variables.Board.get(i - 1).get(j) == state && !search.liberties(Variables.Board, previous, state, i - 1, j)) {
            //System.out.println("1" + previous);
            ((Game) mContext).kill(previous);
        }
        previous.clear();
        if(onBoard(i + 1, j) && Variables.Board.get(i + 1).get(j) == state && !search.liberties(Variables.Board, previous, state, i + 1, j)) {
            //System.out.println("2" + previous);
            ((Game) mContext).kill(previous);
        }
        previous.clear();
        if(onBoard(i, j - 1) && Variables.Board.get(i).get(j - 1) == state && !search.liberties(Variables.Board, previous, state, i, j - 1)) {
            //System.out.println("3" + previous + "-" + state + "-" + Variables.Board.get(i).get(j - 1) + "-");
            ((Game) mContext).kill(previous);
        }
        previous.clear();
        if(onBoard(i, j + 1) && Variables.Board.get(i).get(j + 1) == state && !search.liberties(Variables.Board, previous, state, i, j + 1)) {
            //System.out.println("4" + previous);
            ((Game) mContext).kill(previous);
        }
        previous.clear();
    }

    public static boolean onBoard(int i, int j) {
        return i >= 0 && j >= 0 && i < Variables.boardsizeModifier && j < Variables.boardsizeModifier;
    }

    private static Integer[] drawBoard(int size) {
        Integer[] boardArray = new Integer[size*size];
        for (int i = 0; i < size * size; i++) {
            boardArray[i] = R.drawable.neutral;
        }
        return boardArray;
    }
}
