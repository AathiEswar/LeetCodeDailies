package LeetCodeDaily;

import java.util.HashMap;

public class KthDistinctString {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String , Integer> map = new HashMap<>();

        for(String str : arr){
            map.put(str , map.getOrDefault(str , 0) + 1);
        }

        for(String ar : arr){
            if(map.get(ar) == 1){
                k--;
            }

            if(k == 0){
                return ar;
            }
        }

        return "";
    }
}

