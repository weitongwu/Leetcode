package dfs.tree;

import utils.TreeNode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 *
 *
 * >> understand it wrongly, you define the structure not level traverse , but preorder
 *
 *
 * in: [1,2,3,null,null,4,5]
 * like: 1,2,X,X,3,4,X,X,5,X,X,  in the end
 *
 * Strategy: nodes.addAll(Arrays.asList(data.split(spliter)));
 *
 * 3/21/21
 *
 * Use Deque! or Deque, both work, deque.remove() the first element of the queue
 *
 * 按照中序遍历，周末再走一遍
 *
 * Error:
 * 1. 别忘记 spliter跟在每一个string后
 * 2. 转换公式, Arrays.asList(data.split(splitter))
 * 3. if str/node == null else 再进入
 *
 * 8/30/20.
 */
public class _297_serialize_and_deserialize_binary_tree {

    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return NN;
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public void buildString(TreeNode node, StringBuilder sb){
        if(node == null){
            sb.append(NN).append(spliter) ;
        }else{
            sb.append(node.val).append(spliter);
            buildString(node.left,sb);
            buildString(node.right,sb);
        }
    }
    // why use deque?? - no needed, queue also works

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<String>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    public TreeNode buildTree(Deque<String> nodes){
        String val = nodes.remove();
        if(val.equals(NN)) {
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
}
