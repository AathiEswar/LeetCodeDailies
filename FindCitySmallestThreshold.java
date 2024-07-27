package LeetCodeDaily;
import java.util.*;
public class FindCitySmallestThreshold {
    class FloydsWarshellAlgo{
        public int findTheCity(int n, int[][] edges, int k) {

            int[][] graph  = new int[n][n];

            for(int i = 0 ; i<n ;i++){
                Arrays.fill( graph[i] , Integer.MAX_VALUE) ;
                graph[i][i] = 0;
            }

            for(int[] edge : edges){
                int source = edge[0];
                int dest   = edge[1];
                int cost   = edge[2];

                graph[source][dest] = cost;
                graph[dest][source] = cost;
            }

            for(int mid = 0 ; mid < n ; mid++){
                for(int source = 0 ; source < n ; source++){
                    for(int dest = 0 ; dest < n  ; dest++ ){
                        if(graph[source][mid] < Integer.MAX_VALUE && graph[mid][dest] < Integer.MAX_VALUE){
                            graph[source][dest] =
                                    Math.min(graph[source][dest] , graph[source][mid] + graph[mid][dest] );
                        }
                    }
                }
            }

            int city = 0 ;
            int min = n;

            for(int source = 0 ; source < n ; source++){
                int count = 0;

                for(int dest = 0 ; dest < n ; dest++){
                    if(graph[source][dest] <= k){
                        count++;
                    }
                }

                if(count<=min){
                    city = source;
                    min = count;
                }
            }

            return city ;
        }
    }
    public int findTheCity(int n, int[][] edges, int k) {
        // create adjList
        // traverse through every node and find the max dis it can go
        // return the city

        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();

        for(int i = 0 ; i< n ; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges ){
            adjList.get(edge[0]).add(new int[]{edge[1] , edge[2]});
            adjList.get(edge[1]).add(new int[]{edge[0] , edge[2]});
        }

        int city = 0 ;
        int min = n+1;

        for(int i = 0 ; i < n ; i++){
            int count = bfs( adjList , i , k);

            if(count <= min){
                min = count;
                city = i ;
            }
        }

        return city ;
    }

    public int bfs(ArrayList<ArrayList<int[]>> adjList , int node  , int thresh ){

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1] );
        queue.offer(new int[]{node , 0});

        int[] visited = new int[adjList.size()];

        int count = -1;

        while(!queue.isEmpty()){
            int curNode = queue.peek()[0];
            int curThresh = queue.peek()[1];

            queue.poll();

            if(visited[curNode] == 1){
                continue ;
            }

            visited[curNode] = 1;
            count++;

            for(int[] adjNode : adjList.get(curNode)){
                if(visited[adjNode[0]] != 1 && adjNode[1] + curThresh <= thresh){
                    queue.offer(new int[]{adjNode[0] , adjNode[1] + curThresh });
                }
            }
        }

        return count ;
    }
}
