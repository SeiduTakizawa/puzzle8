import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Board {
    private int rows = 3;
    private int columns = 3;
    private int[][] puzzle8Array;

    private List<Board> boardList = new ArrayList<>();

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.puzzle8Array = new int[rows][columns];
        int[][] start1 = {{1,3,4},{8,6,2},{7,0,5}};
        Board board1 = new Board(start1);
        boardList.add(board1);
        int[][] start2 = {{2,8,1},{0,4,3},{7,6,5}};
        Board board2 = new Board(start2);
        boardList.add(board2);
        int[][] start3 = {{5,6,7},{4,0,8},{3,2,1}};
        Board board3 = new Board(start3);
        boardList.add(board3);
        int[][] start4 = {{7,6,5},{8,3,4},{1,0,2}};
        Board board4 = new Board(start4);
        boardList.add(board4);
        int[][] start5 = {{7,6,5},{8,3,4},{1,0,2}};
        Board board5 = new Board(start5);
        boardList.add(board5);
    }

    public Board(int[][] array){
        this.puzzle8Array = array;
    }

    public void initializePuzzle() {
        System.out.println("pick an array:");
        for (int i = 0;i<boardList.size();i++) {
            System.out.println("Array: "+i);
            boardList.get(i).display();
        }
        System.out.println("pick 5 for og");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if(choice == 0){
            puzzle8Array = boardList.get(0).getArray();
        }
        else if(choice == 1){
            puzzle8Array = boardList.get(1).getArray();
        }
        else if(choice == 2){
            puzzle8Array = boardList.get(2).getArray();
        }
        else if(choice == 3){
            puzzle8Array = boardList.get(3).getArray();
        }
        else if(choice == 4){
            puzzle8Array = boardList.get(4).getArray();
        }
        else if(choice == 5){
            int z = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (i == 0 && j == 2) {
                        puzzle8Array[i][j] = 0;

                    }
                    else {
                        puzzle8Array[i][j] = z;
                        z++;
                    }
                }
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