package LeetCodeDaily;

public class CrawlerLog {
    public int minOperations(String[] logs) {
        int count = 0 ;

        for(String cmd : logs){
            if(cmd.equals("../")){
                count = Math.max(count-1 , 0);
            }
            else if(!cmd.equals("./")){
                count++;
            }

        }
        return count;
    }
}
