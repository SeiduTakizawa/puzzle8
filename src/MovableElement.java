public class MovableElement {

    private int[][] board;
    private final int EMPTY_SPACE = 0;

    public MovableElement(int[][] board) {
        this.board = board;
    }

    public boolean move(int row, int col, Direction direction) {
        int newRow = getNewRow(row, direction);
        int newCol = getNewCol(col, direction);

        if (isValidPosition(newRow, newCol) && board[newRow][newCol] == EMPTY_SPACE) {
            swapElements(row, col, newRow, newCol);
            return true;
        }
        return false;
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

    private void swapElements(int row1, int col1, int row2, int col2) {
        int temp = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = temp;
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
}
