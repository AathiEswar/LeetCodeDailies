package LeetCodeDaily;

public class PassPillow {
    public int passThePillow(int n, int time) {
        int count = 1;
        boolean change = false;
        int i = 1;
        while(time > 0){
            if(change){
                count--;
            }
            else{
                count++;
            }
            if(count == 1 || count == n){
                change = !change ;
            }
            time--;
        }

        return count;
    }
}
