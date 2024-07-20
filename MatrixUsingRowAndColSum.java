package LeetCodeDaily;

public class MatrixUsingRowAndColSum {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

        int rowLen = rowSum.length;
        int colLen = colSum.length;

        int[][] res = new int[rowLen][colLen];

        int i = 0;
        int j = 0;

        while(i < rowLen && j < colLen){

            res[i][j] = Math.min(rowSum[i] , colSum[j]);

            rowSum[i] -= res[i][j];
            colSum[j] -= res[i][j];

            if(rowSum[i] == 0)
                i++;
            if(colSum[j] == 0)
                j++;
        }

        return res;
    }
}
