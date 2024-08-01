package LeetCodeDaily;

public class NoOfSeniorCitizens {
    public int countSeniors(String[] details) {
        int count = 0 ;

        for(int i = 0 ; i<details.length ; i++){
            int unit = (details[i].charAt(12) - '0');
            int tens = (details[i].charAt(11) - '0');

            if(tens*10 + unit > 60){
                count++;
            }
        }

        return count ;
    }
}
