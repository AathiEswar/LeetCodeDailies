package LeetCodeDaily;
import java.util.*;
public class MatrixWithConditionGraph {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer>[] rowGraph = new ArrayList[k + 1];
        for(int i = 1 ; i < rowGraph.length; i ++) {
            rowGraph[i] = new ArrayList();
        }
        for(int [] rowCondition : rowConditions){
            rowGraph[rowCondition[0]].add(rowCondition[1]);
        }

        List<Integer>[] colGraph = new ArrayList[k + 1];
        for(int i = 1 ; i < colGraph.length; i ++) {
            colGraph[i] = new ArrayList();
        }
        for(int [] colCondition : colConditions){
            colGraph[colCondition[0]].add(colCondition[1]);
        }

        int[] visited = new int[k + 1];
        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i < rowGraph.length; i++){
            if(!topSort(rowGraph, i, visited, stack)){
                return new int[0][0];
            }
        }


        int[] rowIndexMap = new int[k + 1];
        for(int i = 0; i < k; i++){
            int node = stack.pop();
            rowIndexMap[node] = i;
        }

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
