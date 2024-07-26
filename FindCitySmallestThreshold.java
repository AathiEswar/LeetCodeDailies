package LeetCodeDaily;
import java.util.*;
public class FindCitySmallestThreshold {
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
