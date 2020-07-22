public interface IGrid {
    String[][] makeGridCopy();
    int traverseGrid(int x1, int y1, int turns, int greenCellsCounter);
    int findGreenNeighbours(int greenCellsCounter, Cell cell);
}
