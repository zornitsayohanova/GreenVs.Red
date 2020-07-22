

public class Cell implements ICell {

    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    //checks if the neighbour is green
    public static int checkCellIsGreen(String[][] grid, int x, int y) {
        if (grid[x][y].equals("1"))
            return 1;

        return 0;
    }

    //if conditions are met, the cell turns to green
    public String[][] transformToGreen(String [][]initialGrid, int greenCellsCounter) {
        if (greenCellsCounter == 3 || greenCellsCounter == 6)
            initialGrid[this.x][this.y] = "1";

        return initialGrid;
    }

    //if conditions are met, the cell turns to red
    public String[][] transformToRed(String [][]initialGrid, int greenCellsCounter) {
        if (greenCellsCounter != 2 && greenCellsCounter != 3 && greenCellsCounter != 6)
            initialGrid[this.x][this.y] = "0";

        return initialGrid;
    }
}
