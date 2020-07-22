

public class Grid implements IGrid{

    private String[][] grid;
    private int cellGreenCounter;

    public Grid() {
        this.cellGreenCounter = 0;
    }

    public Grid(String[][] grid) {
        this.grid = grid;
        cellGreenCounter = 0;
    }

    public void setGrid(String[][] grid) {
        this.grid = grid;
    }

    public String[][] getGrid() {
        return this.grid;
    }

    public String[][] makeGridCopy() {
        String[][] gridCopy = new String[grid.length][grid.length];

        //creates a deep copy of the initial grid
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, gridCopy[i], 0, grid[i].length);
        }

        return gridCopy;
    }

    //checks how many green neighbours the cell has
    public int findGreenNeighbours(int greenCellsCounter, Cell cell) {
        if (cell.getX() - 1 >= 0) {
            greenCellsCounter += Cell.checkCellIsGreen(grid, cell.getX() - 1, cell.getY());
            if (cell.getY() + 1 <= grid.length - 1)
                greenCellsCounter += Cell.checkCellIsGreen(grid, cell.getX() - 1, cell.getY() + 1);
            if (cell.getY() - 1 >= 0)
                greenCellsCounter += Cell.checkCellIsGreen(grid, cell.getX() - 1, cell.getY() - 1);
        }
        if (cell.getX() + 1 <= grid.length - 1) {
            greenCellsCounter += Cell.checkCellIsGreen(grid, cell.getX() + 1, cell.getY());
            if (cell.getY() + 1 <= grid.length - 1)
                greenCellsCounter += Cell.checkCellIsGreen(grid, cell.getX() + 1, cell.getY() + 1);
            if (cell.getY() - 1 >= 0)
                greenCellsCounter += Cell.checkCellIsGreen(grid, cell.getX() + 1, cell.getY() - 1);
        }
        if (cell.getY() - 1 >= 0)
            greenCellsCounter += Cell.checkCellIsGreen(grid, cell.getX(), cell.getY() - 1);
        if (cell.getY() + 1 <= grid.length - 1)
            greenCellsCounter += Cell.checkCellIsGreen(grid, cell.getX(), cell.getY() + 1);

        return greenCellsCounter;
    }


    public int traverseGrid(int x1, int y1, int turns, int greenCellsCounter) {
        String[][] gridCopy = makeGridCopy();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Cell cell = new Cell(i, j);

                //finds the amount of green neighbours
                greenCellsCounter = findGreenNeighbours(greenCellsCounter, cell);

                //checks if the current cell is green or red
                if ((grid[i][j].equals("0")))
                    gridCopy = cell.transformToGreen(gridCopy, greenCellsCounter);
                else
                    gridCopy = cell.transformToRed(gridCopy, greenCellsCounter);

                greenCellsCounter = 0;
            }
        }

        //increments the counter, that finds how many times the cell is turning green
            cellGreenCounter+= Cell.checkCellIsGreen(gridCopy, x1, y1);

        //if the turns are over, the method stops working - otherwise a recursion is performed
        if (turns - 1 == 0) {
            return cellGreenCounter;
        }
        else {
            //shallow copy of the grid
            this.grid = gridCopy;
            return traverseGrid(x1, y1, turns - 1, greenCellsCounter);
        }
    }

    //prints the matrix
    public static void printGrid(String [][]grid) {
        for (String[] strings : grid) {
            for (String string : strings) System.out.print(string + " ");
            System.out.println();
        }
        System.out.println();
    }
}
