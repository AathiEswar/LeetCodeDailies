package LeetCodeDaily;
import java.util.*;
public class LuckyNumberInAMatrix {
    public List<Integer> luckyNumberOptimize(int[][] matrix){
        List<Integer> result = new ArrayList<>();


        for(int i = 0; i<matrix.length;i++){

            int rowMinIndex  = findMinInRow(matrix,i);
            int colMaxVal = matrix[i][rowMinIndex];

            if(isMaxInCol(matrix , colMaxVal , rowMinIndex)){
                result.add(colMaxVal);
            }
        }

        return result;
    }

    public int findMinInRow(int[][] matrix , int row){
        int min = matrix[row][0] ;
        int rowIndex = 0;

        for(int i = 0 ;i<matrix[0].length;i++){
            if(min > matrix[row][i]){
                min = matrix[row][i];
                rowIndex = i;
            }
        }

        return rowIndex;
    }

    public boolean isMaxInCol(int[][] matrix , int maxVal , int maxIndex  ){

        for (int i = 0; i < matrix.length; i++) {
            if(maxVal < matrix[i][maxIndex]){
                return false;
            }
        }

        return true;
    }
    public List<Integer> luckyNumbersOwn (int[][] matrix) {
        ArrayList<Integer> minList = new ArrayList<>();
        ArrayList<Integer> maxList = new ArrayList<>();

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for(int i = 0 ; i<rowLen ;i++){
            int min = matrix[i][0];
            for(int j = 0 ; j < colLen ; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }
            minList.add(min);
        }


        for(int i = 0 ; i < colLen ;i++){
            int max = matrix[0][i];
            for(int j = 0 ; j < rowLen ; j++){
                if(matrix[j][i] > max){
                    max = matrix[j][i];
                }
            }
            maxList.add(max);
        }

        List<Integer> res = new ArrayList<>();

        for(int num : minList){
            if(maxList.contains(num)){
                res.add(num);
            }
        }

        return res;
    }
}
