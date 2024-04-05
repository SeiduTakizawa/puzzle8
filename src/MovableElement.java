import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;

public class MovableElement {

    private int[][] board;
    ArrayList<Direction> directions = new ArrayList<>(EnumSet.allOf(Direction.class));

    public MovableElement(int[][] board) {
        this.board = board;
    }

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

    public int[][] move(Direction direction) {
        // Create a copy of the current board
        int[][] newBoard = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
        // Find the position of the zero element
        int[] zeroPosition = findZeroPosition();

        int row = zeroPosition[0];
        int col = zeroPosition[1];

        int newRow = getNewRow(row, direction);
        int newCol = getNewCol(col, direction);

        // Check if the new position is valid and swap the elements
        if (isValidPosition(newRow, newCol)) {
            swapElements(newBoard, row, col, newRow, newCol);
        }

        return newBoard;
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

    private void swapElements(int[][] board, int row1, int col1, int row2, int col2) {
        int temp = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = temp;
    }
}
