package LeetCodeDaily;
import java.util.*;
public class SortPeopleByFrequency {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        Integer[] nNums = new Integer[nums.length];

        for(int i = 0 ; i< nums.length  ; i++ ){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
            nNums[i] = nums[i];
        }

        Arrays.sort(nNums , (n1 , n2) -> {
            if(map.get(n1) != map.get(n2)){
                return map.get(n1) - map.get(n2);
            }
            else {
                return n2-n1;
            }
        });

        for(int i = 0 ; i< nums.length  ; i++ ){
            //map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
            nums[i] = nNums[i];
        }

        return nums;


    }
}
