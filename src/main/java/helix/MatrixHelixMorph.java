package helix;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
    private static int rows;
    private static int columns;

    private static int traverseRows;
    private static int traverseColumns;

    public static int[][] helix( int[][] inMatrix) {
//        return null; //MODIFY THIS METHOD
        rows = inMatrix.length;
        columns = inMatrix[0].length;

        int[][] matrix = new int[rows][columns];

        int[] matrix2 = new int[rows*columns];

        int h = 0;
        for (int i = 0; i<rows;i++)
        {
            for (int j = 0; j < columns; j++)
            {
                matrix2[h] = inMatrix[i][j];
                h++;
            }
        }

        traverseRows=0;
        traverseColumns=0;
        h=0;

        while (traverseRows < rows && traverseColumns < columns)
        {
            for (int i = traverseColumns; i < columns; i++) {
                matrix[traverseRows][i] = matrix2[h];
                h++;
            }
            traverseRows++;

            for (int i = traverseRows;i<rows;i++)
            {
                matrix[i][columns-1]=matrix2[h];
                h++;
            }
            columns--;

            if (traverseRows < rows)
            {
                for (int i = columns-1; i >= traverseColumns ; i--)
                {
                    matrix[rows-1][i] = matrix2[h];
                    h++;
                }
                rows--;
            }

            if (traverseColumns < columns)
            {
                for (int i = rows-1; i >= traverseRows ; i--)
                {
                    matrix[i][traverseColumns] = matrix2[h];
                    h++;
                }
                traverseColumns++;
            }
        }

        return matrix;
    }
}