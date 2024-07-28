package LeetCodeDaily;
import  java.util.*;
public class MinimumCostToConvertString {
    class OwnOptimize{
        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

            //Floyds Warshal Algo

            int[][] distance = new int[26][26];

            for(int i = 0 ; i< 26 ; i++){
                Arrays.fill(distance[i] , Integer.MAX_VALUE);
                distance[i][i] = 0;
            }

            for(int i = 0 ; i < original.length ; i++){
                int node = changed[i] - 'a';
                int neigh = original[i] - 'a';
                int weight = cost[i] ;

                distance[node][neigh] = Math.min(distance[node][neigh] , weight) ;
            }

            for(int mid = 0 ; mid < 26 ; mid++){
                for(int s = 0 ; s < 26 ;s++){
                    if(distance[s][mid] < Integer.MAX_VALUE){
                        for(int dest = 0 ; dest < 26 ; dest++){
                            if(distance[mid][dest] < Integer.MAX_VALUE){
                                distance[s][dest] = Math.min(distance[s][dest] , distance[s][mid] + distance[mid][dest]);
                            }
                        }
                    }
                }
            }

            long count = 0 ;
            for(int i = 0 ; i < source.length() ; i++){
                int sNode = source.charAt(i) - 'a' ;
                int tNode = target.charAt(i) - 'a' ;

                if( source.charAt(i) != target.charAt(i)){
                    if(distance[tNode][sNode] == Integer.MAX_VALUE){
                        return -1;
                    }
                    count += distance[tNode][sNode];
                }
            }

            return count;
        }

    }
    class Own2Working{
        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

            //Floyds Warshal Algo

            int[][] distance = new int[26][26];

            for(int i = 0 ; i< 26 ; i++){
                Arrays.fill(distance[i] , Integer.MAX_VALUE);
                distance[i][i] = 0;
            }

            for(int i = 0 ; i < original.length ; i++){
                int node = changed[i] - 'a';
                int neigh = original[i] - 'a';
                int weight = cost[i] ;

                distance[node][neigh] = Math.min(distance[node][neigh] , weight) ;
            }

            for(int mid = 0 ; mid < 26 ; mid++){
                for(int s = 0 ; s < 26 ;s++){
                    for(int dest = 0 ; dest < 26 ; dest++){
                        if(distance[s][mid] < Integer.MAX_VALUE && distance[mid][dest] < Integer.MAX_VALUE){
                            distance[s][dest] = Math.min(distance[s][dest] , distance[s][mid] + distance[mid][dest]);
                        }
                    }
                }
            }


            long count = 0 ;
            for(int i = 0 ; i < source.length() ; i++){
                int sNode = source.charAt(i) - 'a' ;
                int tNode = target.charAt(i) - 'a' ;

                if( source.charAt(i) != target.charAt(i)){
                    if(distance[tNode][sNode] == Integer.MAX_VALUE){
                        return -1;
                    }
                    count += distance[tNode][sNode];
                }
            }

            return count;
        }
    }
    class Own1{
        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
            List<List<int[]>> adjList = new ArrayList<>(26);

            for(int i = 0 ; i < 26;i++){
                adjList.add(new ArrayList<>());
            }

            for(int i = 0 ; i < original.length ; i++){
                int node = changed[i] - 'a';
                int neigh = original[i] - 'a';
                int weight = cost[i] ;

                adjList.get(node).add(new int[]{neigh , weight});
            }

            int count = 0 ;
            for(int i = 0 ; i < source.length() ; i++){
                int sNode = source.charAt(i);
                int tNode = target.charAt(i) ;

                if( source.charAt(i) != target.charAt(i)){
                    int shortest = dijikstra(tNode - 'a' , sNode - 'a' ,adjList );
                    if(shortest == -1){
                        return -1;
                    }
                    count += shortest;
                }
            }

            return count;
        }

        public int dijikstra(int node , int dest ,List<List<int[]>> adjList ){

            PriorityQueue<int[]> queue = new PriorityQueue<>((a , b) -> a[1] - b[1] );

            int[] distance = new int[26];
            Arrays.fill(distance , Integer.MAX_VALUE);
            distance[node] = 0;

            queue.offer(new int[]{node , 0});

            while(!queue.isEmpty()){
                int curNode = queue.peek()[0];
                int curValue = queue.peek()[1];
                queue.poll();

                for(int[] adjNode : adjList.get(curNode)){
                    int aNode = adjNode[0];
                    int aValue = adjNode[1];

                    if(curValue + aValue < distance[aNode]) {
                        distance[aNode] = curValue + aValue ;
                        queue.offer(new int[]{aNode , distance[aNode]});
                    }
                }

            }

            return distance[dest] == Integer.MAX_VALUE ? -1 : distance[dest];
        }
    }
}
