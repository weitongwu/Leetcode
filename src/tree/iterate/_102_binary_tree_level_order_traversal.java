package tree.iterate;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * M1:
 * - dfs 一层一层向里加
 * dfs(res, node.left, level+1);
 *
 * M2:
 * - 确定是用queue 还是stack   queue.offer  && queue.poll
 * - 定好number 后
 * while + for 向里前进
 *
 *
 * 7/20/20.
 */
public class _102_binary_tree_level_order_traversal {

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        dfs(res, root,0);
        return res;
    }

    public void dfs(List<List<Integer>> res, TreeNode node, int level){
        if(node == null) return ;
        if(res.size() <= level){
            res.add(new LinkedList<Integer>());
        }

        res.get(level).add(node.val);

        dfs(res, node.left, level+1);
        dfs(res, node.right, level+1);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<Integer>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    list.add(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if(list.size()!=0){
                res.add(list);
            }
        }
        return res;
    }


}
