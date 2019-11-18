import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelOrder {
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        Map<Integer,List<Integer>> levelMap = new HashMap<>();
//        traverseTree(root,0,levelMap);
//        List<List<Integer>> sortedLevels = new ArrayList<>();
//        levelMap.keySet().stream().sorted().forEach(key -> sortedLevels.add(levelMap.get(key)));
//        return sortedLevels;
//    }
//
//    public void traverseTree(TreeNode node, Integer level, Map<Integer,List<Integer>> levelMap) {
//        if (node == null) {
//            return;
//        }
//        List<Integer> levelList = levelMap.getOrDefault(level,new ArrayList<>());
//        levelList.add(node.val);
//        levelMap.put(level,levelList);
//        traverseTree(node.left,level+1,levelMap);
//        traverseTree(node.right,level+1,levelMap);
//    }
}
