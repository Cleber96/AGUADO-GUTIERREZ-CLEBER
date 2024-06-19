package org.example;

public class Map {
    private final int EMPTY = 0;
    private final int PATH = 1;
    private final int BASE = 2;
    private int[][] grid;

    public Map() {
        grid = new int[][] {
                {EMPTY, EMPTY, PATH, EMPTY, EMPTY},
                {EMPTY, PATH, EMPTY, EMPTY, EMPTY},
                {PATH, EMPTY, EMPTY, PATH, BASE},
                {EMPTY, EMPTY, PATH, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}
        };
    }

    public boolean isValidPosition(int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }
        return grid[x][y] == EMPTY;
    }

    public boolean placeTower(int x, int y) {
        if (isValidPosition(x, y)) {
            grid[x][y] = 3;
            return true;
        }
        return false;
    }

    public void printMap() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(getSymbol(grid[i][j]));
            }
            System.out.println();
        }
    }

    private String getSymbol(int cellType) {
        switch (cellType) {
            case EMPTY:
                return "[ ]";
            case PATH:
                return "[C]";
            case BASE:
                return "[B]";
            case 3:
                return "[T]";
            default:
                return "[ ]";
        }
    }
}



