import java.util.*;
public class Grid
{
    private static final int SIZE = 10;
    private int[][] pixels = new int[SIZE][SIZE];
    private Stack<Pair> stack = new Stack<Pair>();

    /**
     * Flood fill, starting with the given row and column.
    */
    public void floodfill(int row, int column)
    {
        if (row < 0 || row >= SIZE || column < 0 || column >= SIZE)
            return;

        stack.clear();
        stack.push(new Pair(row, column));
        int nextValue = 1;

        while (!stack.isEmpty())
        {
            Pair current = stack.pop();
            int r = current.getRow();
            int c = current.getColumn();

            if (r < 0 || r >= SIZE || c < 0 || c >= SIZE)
                continue;
            if (pixels[r][c] != 0)
                continue;

            pixels[r][c] = nextValue++;
            
            if (c > 0)
                stack.push(new Pair(r, c - 1));
            if (r < SIZE - 1)
                stack.push(new Pair(r + 1, c));
            if (c < SIZE - 1)
                stack.push(new Pair(r, c + 1));
            if (r > 0)
                stack.push(new Pair(r - 1, c));
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
