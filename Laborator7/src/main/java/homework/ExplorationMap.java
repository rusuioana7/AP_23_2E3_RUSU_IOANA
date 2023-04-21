package homework;

import java.util.*;

public class ExplorationMap {
    private final Cell[][] matrix;
    private final int rows;
    private final int columns;
    private int n;

    public ExplorationMap(int n) {
        this.columns = n;
        this.rows = n;
        matrix = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = new Cell();
            }
        }
    }

    public boolean visit(int row, int columns, Robot robot) {
        synchronized (matrix[row][columns]) {
            if (!matrix[row][columns].isVisited()) {
                List<Token> tokens = robot.getExtractedTokens();
                matrix[row][columns].addTokens(tokens);
                matrix[row][columns].setVisited(true);
                System.out.println(robot.getName() + " visited cell (" + row + "," + columns + ") and added " + tokens.toString());
                return true;
            } else {
                return false;
            }
        }
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getN() {
        return n;
    }

    public int getColumns() {
        return columns;
    }

    public boolean hasUnexploredCell() {//checks if there are unexplored cells in the map
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!matrix[i][j].isVisited()) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] getUnexploredCell() {//exploring the map row by row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!matrix[i][j].isVisited()) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "ExplorationMap{" +
                "matrix=" + Arrays.toString(matrix) +
                ", rows=" + rows +
                ", columns=" + columns +
                ", n=" + n +
                '}';
    }
}
