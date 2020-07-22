import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //the size of the grid is converted to int
        int x = Integer.parseInt(String.valueOf(input.toCharArray()[0]));
        int y = Integer.parseInt(String.valueOf(input.toCharArray()[3]));

        //creates an empty 2d string array
        String[][] gridInput = new String[y][x];

        for (int i = 0; i < y; i++) {
            String gridLine = scanner.next();

            for (int j = 0; j < gridLine.toCharArray().length; j++) {

                //fills the 2d array with the input matrix
                gridInput[i][j] = String.valueOf(gridLine.toCharArray()[j]);
            }
            scanner.nextLine();
        }

        Grid grid = new Grid(gridInput);

        //saves the input coordinates of a concrete cell
        String coordinatesInput = scanner.nextLine();

        //using a regex pattern to remove empty spaces and commas
        coordinatesInput = coordinatesInput.replaceAll("[^-?0-9]+", " ");

        //saves the result in a new string array
        String[] coordinates = (coordinatesInput.trim().split(" "));

        //the cell coordinates and number of turns are converted to int
        int y1 = Integer.parseInt(coordinates[0]);
        int x1 = Integer.parseInt(coordinates[1]);
        int n = Integer.parseInt(coordinates[2]);

        //checks if the cell is green
        int greenCellsCounter = Cell.checkCellIsGreen(gridInput, x1, y1);

        //prints how many generations this cell has become green
        System.out.println(grid.traverseGrid(x1, y1, n, greenCellsCounter));
    }
}
