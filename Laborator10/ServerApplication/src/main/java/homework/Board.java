package homework;

public class Board {
    private char[][] grid;
    private static final char BLANK_SYMBOL = ' ';

    public Board(int rows, int cols) {
        grid = new char[rows][cols];
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public int getRows() {
        return grid.length;
    }

    public int getCols() {
        return grid[0].length;
    }

    public char getValue(int row, int col) {
        return grid[row][col];
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < getRows() && col >= 0 && col < getCols() && grid[row][col] == ' ';
    }

    public void makeMove(int row, int col, char symbol) {
        grid[row][col] = symbol;
    }

    public boolean hasWinner(int row, int col, char symbol) {
        //row
        int count = 0;
        for (int i = col - 4; i <= col + 4; i++) {
            if (i < 0 || i >= getCols()) {
                continue;
            }
            if (grid[row][i] == symbol) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        //column
        count = 0;
        for (int i = row - 4; i <= row + 4; i++) {
            if (i < 0 || i >= getRows()) {
                continue;
            }
            if (grid[i][col] == symbol) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        //diagonal
        boolean diagonalWin = true;
        for (int i = 0; i < getRows(); i++) {
            if (grid[i][i] != symbol) {
                diagonalWin = false;
                break;
            }
        }
        if (diagonalWin) {
            return true;
        }

        //reverse diagonal
        boolean reverseDiagonalWin = true;
        for (int i = 0; i < getRows(); i++) {
            if (grid[i][getCols() - 1 - i] != symbol) {
                reverseDiagonalWin = false;
                break;
            }
        }
        if (reverseDiagonalWin) {
            return true;
        }

        return false;
    }


    public boolean isFull() {
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getCols(); j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }


    public void display() {
        for (int row = 1; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                char symbol = grid[row][col];
                if (symbol == BLANK_SYMBOL) {
                    System.out.print(BLANK_SYMBOL);
                } else {
                    System.out.print(symbol);
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("---------------------");
    }


    public char[][] getGrid() {
        return grid;
    }
}
