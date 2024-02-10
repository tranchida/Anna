package m521.tranchida;

import java.util.Random;

public class Papa {
    
    public static void main(String[] args) {
        
        String word = "CHARLIE";
        int rows = 20;
        int cols = 20;


        char[][] tableau;

        // cas 1
        tableau = fill(rows,cols);
        insertWord(tableau, word , true, false);
        display(tableau);

        // cas 2
        tableau = fill(rows,cols);
        insertWord(tableau, word, true, true);
        display(tableau);

        // cas 3
        tableau = fill(rows,cols);
        insertWord(tableau, word, false, true);
        display(tableau);

    }

    public static char[][] fill( int row, int column) {

        Random random = new Random(System.currentTimeMillis());

        char[][] tableau = new char[row][column];

        for (int r = 0; r < row; r++) {

            for (int c = 0; c < column; c++) {
                tableau[r][c] = (char) (random.nextInt(26) + 'A');
            }

        }

        return tableau;

    }

    public static void insertWord(char[][] tableau, String word, boolean x, boolean y) {

        Random random = new Random();

        int startRow = random.nextInt(tableau.length) - (y == true ? word.length() : 0);
        if (startRow < 0) {
            startRow = 0;
        }
        int startColumn = random.nextInt(tableau[0].length) - (x == true ? word.length() : 0);
        if (startColumn < 0) {
            startColumn = 0;
        }

        for (int i=0; i<word.length(); i++) {

            tableau[startRow + (y == true ? i : 0)][startColumn + (x == true ? i : 0)] = word.charAt(i);

        }

    }


    public static void display(char[][] tableau) {

        for(int r=0; r< tableau.length; r++ ) {

            for (int c = 0; c < tableau[r].length; c++) {
                System.out.print(tableau[r][c] + " ");
            }

            System.out.println();
        }

        System.out.println("\n\n");

    }

}
