import java.util.*;

public class Board {
    private int rows = 3;
    private int columns = 3;
    private int[][] board;
    private List<Board> boardList = new ArrayList<>();
    private int targetArray[][] = {{6, 5, 4}, {7, 0, 3}, {8, 1, 2}};
    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.board = new int[rows][columns];
        int[][] start1 = {{1,3,4},{8,6,2},{7,0,5}};
        Board board1 = new Board(start1);
        boardList.add(board1);
        int[][] start2 = {{7,6,5},{8,3,4},{1,0,2}};
        Board board2 = new Board(start2);
        boardList.add(board2);
        int[][] start3 = {{8,4,6},{3,1,5},{2,0,7}};
        Board board3 = new Board(start3);
        boardList.add(board3);
        int[][] start4 = {{2,8,1},{0,4,3},{7,6,5}};
        Board board4 = new Board(start4);
        boardList.add(board4);
        int[][] start5 = {{7,6,5},{8,3,4},{1,0,2}};
        Board board5 = new Board(start5);
        boardList.add(board5);
    }

    public Board(int[][] array){
        this.board = array;
    }
    public void setBoard(Node node){
        board = node.getState();
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
            board = boardList.get(0).getArray();
        }
        else if(choice == 1){
            board = boardList.get(1).getArray();
        }
        else if(choice == 2){
            board = boardList.get(2).getArray();
        }
        else if(choice == 3){
            board = boardList.get(3).getArray();
        }
        else if(choice == 4){
            board = boardList.get(4).getArray();
        }
        else if(choice == 5){
            int z = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (i == 0 && j == 2) {
                        board[i][j] = 0;

                    }
                    else {
                        board[i][j] = z;
                        z++;
                    }
                }

            }
        }
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public int[][] getArray() {
        return this.board;
    }

    ArrayList<Direction> directions = new ArrayList<>(EnumSet.allOf(Direction.class));

    public boolean canMove(Direction direction) {
        // Find the position of the zero element
        int[] zeroPosition = findZeroPosition();

        int row = zeroPosition[0];
        int col = zeroPosition[1];

        int newRow = getNewRow(row, direction);
        int newCol = getNewCol(col, direction);

        // Check if the new position is valid
        return isValidPosition(newRow, newCol);
    }

    public ArrayList<Direction> getPossibleMoves() {
        return possibleMoves;
    }
    private ArrayList<Direction> possibleMoves = new ArrayList<>();

    public void setPossibleMoves(){
        for (Direction direction : directions) {
            if (canMove(direction)){
                possibleMoves.add(direction);
            }
        }
    }
    private int getNewRow(int row, Direction direction) {
        return switch (direction) {
            case UP, UP_LEFT, UP_RIGHT -> row - 1;
            case DOWN, DOWN_LEFT, DOWN_RIGHT -> row + 1;
            default -> row;
        };
    }

    private int getNewCol(int col, Direction direction) {
        return switch (direction) {
            case LEFT, UP_LEFT, DOWN_LEFT -> col - 1;
            case RIGHT, UP_RIGHT, DOWN_RIGHT -> col + 1;
            default -> col;
        };
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    public int move(Direction direction) {
        // Create a copy of the current board
        int[][] newBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);

        // Find the position of  zero element
        int[] zeroPosition = findZeroPosition();

        int row = zeroPosition[0];
        int col = zeroPosition[1];

        int newRow = getNewRow(row, direction);
        int newCol = getNewCol(col, direction);
        int selected = 0;
        // Check if the new position is valid and swap the elements
        if (isValidPosition(newRow, newCol)) {
            selected = swapElements(newBoard, row, col, newRow, newCol);
        }
        this.board = newBoard;
        return selected;
    }
    public int[][] getBoard() {
        return board;
    }

    private int[] findZeroPosition() {
        int[] position = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) { // Checking for the integer 0
                    position[0] = i;
                    position[1] = j;
                    return position;
                }
            }
        }
        return position; // This should never happen if your board is properly initialized
    }

    public ArrayList<Direction> getDirections() {
        return directions;
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT,
        UP_LEFT,
        DOWN_LEFT,
        UP_RIGHT,
        DOWN_RIGHT
    }

    private int swapElements(int[][] board, int row1, int col1, int row2, int col2) {
        int temp = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = temp;
        return board[row1][col1];
    }
}