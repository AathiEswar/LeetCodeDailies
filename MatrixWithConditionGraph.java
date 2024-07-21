package LeetCodeDaily;
import java.util.*;
public class MatrixWithConditionGraph {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // adjlist for row
        List<Integer>[] rowGraph = new ArrayList[k + 1];
        for(int i = 1 ; i < rowGraph.length; i ++) {
            rowGraph[i] = new ArrayList();
        }
        // add nodes to the adj row list
        for(int [] rowCondition : rowConditions){
            rowGraph[rowCondition[0]].add(rowCondition[1]);
        }

        // adjList for col
        List<Integer>[] colGraph = new ArrayList[k + 1];
        for(int i = 1 ; i < colGraph.length; i ++) {
            colGraph[i] = new ArrayList();
        }

        // add nodes to the adj col list
        for(int [] colCondition : colConditions){
            colGraph[colCondition[0]].add(colCondition[1]);
        }

        // initialize extra ds

        // visited array for dfs
        int[] visited = new int[k + 1];

        // stack for topological sort
        Stack<Integer> stack = new Stack<>();

        // dfs each node nad if cycle is found return empty array
        for(int i = 1; i < rowGraph.length; i++){
            if(!topSort(rowGraph, i, visited, stack)){
                return new int[0][0];
            }
        }


        //  if no cycle use the res topo stack to create an array
        int[] rowIndexMap = new int[k + 1];

        for(int i = 0; i < k; i++){
            // get the order and store their order in their index
            // eg Topo Order = [ 3, 1 , 2 ]
            // rowIndex = [ -1 , 1(1), 2(2) , 0(3) ]

            int node = stack.pop();
            rowIndexMap[node] = i;
        }

        // do the same for col
        visited = new int[k + 1];
        stack = new Stack<>();
        for(int i = 1; i < colGraph.length; i++){
            if(!topSort(colGraph, i, visited, stack)){
                return new int[0][0];
            }
        }

        int[] colIndexMap = new int[k+1];
        for(int i = 0; i < k; i++){
            int node = stack.pop();
            colIndexMap[node] = i;
        }


        int[][] result = new int[k][k];


        // each rowIndex and colIndex has the index of the cur position
        for(int i = 1; i <= k; i++){
            result[rowIndexMap[i]][colIndexMap[i]] = i;
        }

        return result;

    }

    public boolean topSort(List<Integer>[] graph, int node, int[] visited, Stack<Integer> stack ){
        if(visited[node] == 2) {
            return false;
        }
        if(visited[node] == 0){
            visited[node] = 2;
            for(int child : graph[node]){
                if(!topSort(graph, child, visited, stack)){
                    return false;
                }
            }
            visited[node] = 1;
            stack.push(node);
        }
        return true;
    }
}
