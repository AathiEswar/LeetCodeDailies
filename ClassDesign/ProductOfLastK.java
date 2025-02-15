package LeetCodeDaily.ClassDesign;

import java.util.ArrayList;
import java.util.List;

public class ProductOfLastK {
    class ProductOfNumbers {

        List<Integer> list ;
        int totalProduct ;

        public ProductOfNumbers() {
            list = new ArrayList<>();
            totalProduct = 1;
        }

        public void add(int num) {
            if(num == 0){
                list = new ArrayList<>();
                totalProduct = 1;
                return ;
            }
            totalProduct *= num;
            list.add(totalProduct);
        }

        public int getProduct(int k) {
            int size = list.size();

            if( k > size ) return 0;

            int latestProduct = list.get(size - 1);

            if( k == size) return latestProduct;

            return latestProduct / list.get( size - 1 - k );
        }
    }

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
}
