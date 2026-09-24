import java.util.*;
public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];
    Stack<Pair> stack = new Stack<Pair>();
    Pair pair;

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        pair = new Pair(row, column);
        //embed in if statement
        if (pixels[row - 1][column] == 0) {
            if (row >= 0 && row < SIZE  && column >= 0 && column < SIZE) {
                stack.push(pair);
                floodfill(row - 1, column);
            }
        }
        else if (pixels[row][column + 1] == 0) {
            if (row >= 0 && row < SIZE  && column >= 0 && column < SIZE) {
                stack.push(pair);
                floodfill(row, column + 1);
            }
        }
        else if (pixels[row + 1][column] == 0) {
            if (row >= 0 && row < SIZE  && column >= 0 && column < SIZE) {
                stack.push(pair);
                floodfill(row + 1, column);
            }
        }
        else if (pixels[row][column - 1] == 0) {
            if (row >= 0 && row < SIZE  && column >= 0 && column < SIZE) {
                stack.push(pair);
                floodfill(row, column - 1);
            }
        }
        else {
            return;
        }
    }

    public void populate()
    {
        System.out.println(stack.size());
        for (int i = 99; i > 0; i--){
            Pair p = stack.get(i);
            pixels[p.getRow()][p.getColumn()] = i;
        }
    }
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%3d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
}
