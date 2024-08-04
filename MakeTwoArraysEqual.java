package LeetCodeDaily;

public class MakeTwoArraysEqual {
    class OPT2{
        public boolean canBeEqual(int[] targetArray, int[] currentArray) {

            int[] elementCounts = new int[1001];
            int uniqueCount = 0;

            for (int i = 0; i < targetArray.length; i++) {
                if (elementCounts[targetArray[i]]++ == 0) uniqueCount++;
                if (elementCounts[currentArray[i]]-- == 1) uniqueCount--;
            }

            return uniqueCount == 0;
        }
    }
    class OPT{
        public boolean canBeEqual(int[] target, int[] arr) {
            int[] freq = new int[1001];

            for(int i = 0 ; i< arr.length  ; i++){
                freq[arr[i]]++;
                freq[target[i]]--;
            }

            for(int i = 0 ; i<target.length ; i++){
                if(freq[target[i]] != 0){
                    return false;
                }
            }

            return true;

        }
    }
    class OWN{
        public boolean canBeEqual(int[] target, int[] arr) {
            int[] freq = new int[1001];

            for(int i = 0 ; i< arr.length  ; i++){
                freq[arr[i]]++;
                freq[target[i]]--;
            }

            for(int num : freq){
                if(num != 0){
                    return false;
                }
            }

            return true;

        }
    }
}
