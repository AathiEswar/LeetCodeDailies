package LeetCodeDaily;

public class SortTheArray {
    class MergeSort{
        public int[] sortArray(int[] nums) {
            mergeSort(nums , 0 , nums.length );
            return nums;
        }

        public void mergeSort(int[] nums , int start , int end){
            if( end - start == 1){
                return ;
            }

            int mid = start + ( end - start)/2;

            mergeSort(nums , start , mid);
            mergeSort(nums , mid , end);

            merge(nums , start , mid , end);
        }

        public void merge(int[] nums , int start , int mid , int end){
            int[] mergeArray = new int[end - start ];

            int i = start ;
            int j = mid ;
            int k = 0 ;
            while(i < mid && j < end ){
                if(nums[i] > nums[j]){
                    mergeArray[k] = nums[j];
                    j++;
                }
                else{
                    mergeArray[k] = nums[i];
                    i++;
                }
                k++;
            }

            while(i < mid){
                mergeArray[k] = nums[i];
                i++;
                k++;
            }
            while(j < end){
                mergeArray[k] = nums[j];
                j++;
                k++;
            }

            for(int l = 0 ; l < mergeArray.length  ; l++){
                nums[l+start] = mergeArray[l];
            }


        }
    }
}
