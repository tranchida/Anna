package m521.tranchida;

import java.util.Random;

public class PapaWithClass {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        // cas 1
        PapaWithClass cas1 = new PapaWithClass("CHARLIE", 20, 20, Direction.HORIZONTAL);
        cas1.display();

        // cas 2
        PapaWithClass cas2 = new PapaWithClass("CHARLIE", 20, 20, Direction.DIAGONAL);
        cas2.display();

        // cas 3
        PapaWithClass cas3 = new PapaWithClass("CHARLIE", 20, 20, Direction.VERTICAL);
        cas3.display();

    }

    private String word;
    private int rows;
    private int cols;
    private Direction direction;

    private String[][] tableau;

    public enum Direction {

        HORIZONTAL(true, false),
        VERTICAL(false, true),
        DIAGONAL(true, true);

        private boolean x;
        private boolean y;

        private Direction(boolean x, boolean y) {
            this.x = x;
            this.y = y;
        }

    }

    public PapaWithClass(String word, int rows, int cols, Direction direction) {
        this.word = word;
        this.rows = rows;
        this.cols = cols;
        this.direction = direction;

        fill();
        insertWord();

    }

    private void fill() {

        Random random = new Random(System.currentTimeMillis());

        tableau = new String[rows][cols];

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {
                tableau[r][c] = "" + (char) (random.nextInt(26) + 'A');
            }

        }

    }

    private void insertWord() {

        Random random = new Random();

        int startRow = random.nextInt(tableau.length) - (direction.y == true ? word.length() : 0);
        if (startRow < 0) {
            startRow = 0;
        }
        int startColumn = random.nextInt(tableau[0].length) - (direction.x == true ? word.length() : 0);
        if (startColumn < 0) {
            startColumn = 0;
        }

        for (int i = 0; i < word.length(); i++) {

            tableau[startRow + (direction.y == true ? i : 0)][startColumn + (direction.x == true ? i : 0)] = ANSI_RED + word.charAt(i) + ANSI_RESET;
        
        }

    }

    public void display() {

        for (int r = 0; r < tableau.length; r++) {

            for (int c = 0; c < tableau[r].length; c++) {
                System.out.print(tableau[r][c] + " ");
            }

            System.out.println();
        }

        System.out.println("\n\n");

    }

}
