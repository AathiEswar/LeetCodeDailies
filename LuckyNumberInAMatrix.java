package LeetCodeDaily;
import java.util.*;
public class LuckyNumberInAMatrix {
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
