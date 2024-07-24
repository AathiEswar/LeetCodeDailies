package LeetCodeDaily;

public class SortJumbledArray {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // create a mapping array 2d
        // construct the changed value and map it to the index
        // sort using comparator ( when value is same look for index )
        // add them sorted array to a new array
        // return it

        int len = nums.length ;

        int[][] map = new int[len][2];

        for(int i = 0 ; i < len ; i++){
            int curNum = nums[i];
            int mappedvalue = (curNum == 0) ? mapping[0] : 0;

            int base = 1;

            while(curNum > 0){
                int digit = curNum % 10;
                curNum /= 10;

                mappedvalue += base * mapping[digit];
                base *= 10;
            }

            map[i] = new int[]{mappedvalue , i};

        }

        Arrays.sort(map , (a , b) -> {
            if(a[0] == b[0] ){
                return a[1] - b[1];
            }
            else {
                return a[0] - b[0];
            }
        });

        int[] res = new int[len];

        for(int i = 0 ; i<len ; i++){
            res[i] = nums[map[i][1]];
        }

        return res;

    }
}
