package LeetCodeDaily;

import java.util.Arrays;
import java.util.PriorityQueue;

public class RangeSumOfArray {
    class PQ{
        public int rangeSum(int[] nums, int n, int left, int right) {
            int mod = (int)1e9 + 7;

            PriorityQueue<int[]> queue  = new PriorityQueue<>((a, b) -> a[0] - b[0]);

            for(int i = 0 ; i < n ; i++){
                queue.offer(new int[]{nums[i] , i });
            }

            int res = 0 ;

            for(int i = 0 ;  i <= right-1 ; i++){
                int[] cur = queue.poll();
                int value = cur[0];
                int index = cur[1];

                if(i >= left-1){
                    res = ( res + value) % mod;
                }

                if(index < n-1){
                    cur[0] = (cur[0] + nums[++cur[1]]) % mod;
                    queue.offer(cur);
                }

            }

            return res;
        }
    }
    class OWN{
        public int rangeSum(int[] nums, int n, int left, int right) {
            int len = (n * (n+1))/2;
            int[] res = new int[len];

            int index = 0 ;

            for(int i = 0 ; i < nums.length ; i++){
                int sum = 0;
                for(int j = i ; j < nums.length ; j++){
                    sum += nums[j] ;
                    // System.out.println(sum);
                    res[index++] = sum;
                }
            }

            Arrays.sort(res);
            //System.out.println(Arrays.toString(res));

            int sumRes = 0;
            for(int ind = left-1 ; ind <= right-1 ; ind++){
                sumRes = ( sumRes + res[ind] ) % ((int) 1e9 + 7);
            }

            return sumRes;
        }
    }
}
