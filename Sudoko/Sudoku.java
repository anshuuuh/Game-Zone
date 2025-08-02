package Su;
public class Sudoku {
    private int[][] board = new int[9][9];
    private int[][] initialBoard = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    public Sudoku() {
        // Copy initial board to current board
        for (int i = 0; i < 9; i++)
            System.arraycopy(initialBoard[i], 0, board[i], 0, 9);
    }

    public int[][] getBoard() {
        return board;
    }

    public boolean setNumber(int row, int col, int num) {
        if (initialBoard[row][col] != 0) return false; // Can't change original numbers
        if (isValidMove(row, col, num)) {
            board[row][col] = num;
            return true;
        }
        return false;
    }

    private boolean isValidMove(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) return false;
        }
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }
        return true;
    }

    public boolean isComplete() {
        for (int[] row : board) {
            for (int n : row) {
                if (n == 0) return false;
            }
        }
        return true;
    }
}
