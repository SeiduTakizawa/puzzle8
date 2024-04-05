import java.util.Scanner;
import java.util.Random;

public class Board {
    private int rows;
    private int columns;
    private int[][] puzzle8Array;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.puzzle8Array = new int[rows][columns];
    }

    public void initializePuzzle() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();


        int emptyRow = random.nextInt(rows);
        int emptyCol = random.nextInt(columns);

        int z = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == 1 && j ==1) {
                    puzzle8Array[i][j] = 0;
                    z++;
                }
                else {
                    puzzle8Array[i][j] = z;
                    z++;
                }
                /*
                if (i == emptyRow && j == emptyCol) {
                    puzzle8Array[i][j] = 0;
                } else {
                    System.out.print("Enter the number for position (" + i + ", " + j + "): ");
                    puzzle8Array[i][j] = scanner.nextInt();
                }
                */
                    }
        }
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(puzzle8Array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public int[][] getArray() {
        return this.puzzle8Array;
    }

}