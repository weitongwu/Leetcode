package bfs;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 1/13/21
 *
 * 重新理解dfs, bfs的不同
 *
 * ----
 * 细节处注意：
 * > CC: if root == null
 *
 * > if(node.left != null) queue.add(node.left);
 *
 *
 * M2:
 * dfs -> 为什么会好用，每次添的就是先浏览的node.right
 *

 (1) the traverse of the tree is NOT standard pre-order traverse. It checks the RIGHT node first and then the LEFT
 (2) the line to check currDepth == result.size() makes sure the first element of that level will be added to the result list
 (3) if reverse the visit order, that is first LEFT and then RIGHT, it will return the left view of the tree.

 *
 *
 * 8/22/20.
 */
public class _199_binary_tree_right_side_view {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i <size; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                if(i==size-1){
                    list.add(node.val);
                }
            }
        }
        return list;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if(root == null) return list;

        dfs(root,list,0);
        return list;
    }

    public void dfs(TreeNode node, List<Integer> list, int level){
        if(node == null){
            return ;
        }
        // 1. what's in here
        // 第一次 loop到每个level的 边界点

        if(level == list.size()){
            list.add(node.val);
        }
        // 2. why right first not left
        // need to see the right face value first
        dfs(node.right, list, level+1);
        dfs(node.left, list, level+1);
    }
}
