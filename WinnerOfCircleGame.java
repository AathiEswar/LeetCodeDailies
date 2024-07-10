package LeetCodeDaily;

import java.util.ArrayList;

public class WinnerOfCircleGame {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 1 ;i<= n ; i++ ){
            res.add(i);
        }

        int indexToMove  = 0;

        while(res.size() != 1){

            int nextMove = (indexToMove + k-1) % res.size();
            res.remove(nextMove);
            indexToMove = nextMove;
        }

        return res.get(0);
    }
}
