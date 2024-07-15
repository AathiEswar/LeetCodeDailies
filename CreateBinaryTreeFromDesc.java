package LeetCodeDaily;
import ProblemSolving.BFS.TreeNode;

import java.util.*;
public class CreateBinaryTreeFromDesc {
    public TreeNode createBinaryTree(int[][] desc) {
        HashMap<Integer , TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < desc.length ; i++ ){
            int root  = desc[i][0];
            int child = desc[i][1];
            int isleft = desc[i][2];

            set.add(child);

            if(!map.containsKey(root)){
                map.put(root , new TreeNode(root));
            }
            if(!map.containsKey(child)){
                map.put(child , new TreeNode(child));
            }

            if(isleft == 1){
                map.get(root).left = map.get(child);
            }
            else{
                map.get(root).right = map.get(child);
            }
        }

        for(int i = 0 ; i < desc.length ; i++){

            if(!set.contains(desc[i][0])){
                return map.get(desc[i][0]);
            }
        }

        return new TreeNode(0);
    }
}
