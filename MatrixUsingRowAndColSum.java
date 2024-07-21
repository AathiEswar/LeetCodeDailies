package LeetCodeDaily;

public class MatrixUsingRowAndColSum {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        // algorithm is based on resource allocation in RMT
        // matrix colSum == rowSum

        // initialize
        int rowLen = rowSum.length;
        int colLen = colSum.length;

        int[][] res = new int[rowLen][colLen];

        int i = 0;
        int j = 0;

        // loop till one of them gets to the end
        while(i < rowLen && j < colLen){
            // take the min of rowSum and colSum and add it to the grid
            res[i][j] = Math.min(rowSum[i] , colSum[j]);

            // sub the min to both rowSum and colSum
            rowSum[i] -= res[i][j];
            colSum[j] -= res[i][j];

            // if the cur rowSUm or colSum is 0 no need to allocate to it
            if(rowSum[i] == 0)
                i++;
            if(colSum[j] == 0)
                j++;
        }

        return res;
    }
}
