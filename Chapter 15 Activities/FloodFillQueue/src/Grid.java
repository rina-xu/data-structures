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
        int num = 1;
        stack.push(pair);
        while (!stack.isEmpty()) {
            for (int i = row; i < SIZE - row; i++)
            {
                for (int j = column; j < SIZE - column; j++)
                {
                    if (pixels[i][j] == 0)
                    {
                        pixels[i][j] = num;
                        pair = new Pair(i, j);
                        stack.push(pair);
                    }
                }
            }
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
