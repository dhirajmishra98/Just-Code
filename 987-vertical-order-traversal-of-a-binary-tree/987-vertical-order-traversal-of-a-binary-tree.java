/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
   public List<List<Integer>> verticalTraversal(TreeNode root) {
		Map<Integer, Map<Integer, List<Integer>>> report = new TreeMap<>();
		dfs(root, report, 0, 0);
		List<List<Integer>> res = new ArrayList<>();
		for (int x : report.keySet()) {
			List<Integer> list = new ArrayList<>();
			Map<Integer, List<Integer>> map = report.get(x);
			for (int y : map.keySet()) {
				List<Integer> l = map.get(y);
				Collections.sort(l);
				list.addAll(l);
			}
			res.add(list);
		}
		return res;
	}

	public void dfs(TreeNode root, Map<Integer, Map<Integer, List<Integer>>> report, int x, int y) {
		if (root == null) {
			return;
		}
		if (report.containsKey(x)) {
			Map<Integer, List<Integer>> map = report.get(x);
			if (map.containsKey(y)) {
				List<Integer> list = map.get(y);
				list.add(root.val);
				map.put(y, list);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(root.val);
				map.put(y, list);
			}
			report.put(x, map);
		} else {
			Map<Integer, List<Integer>> map = new TreeMap<>();
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			map.put(y, list);
			report.put(x, map);
		}
		dfs(root.left, report, x - 1, y + 1);
		dfs(root.right, report, x + 1, y + 1);
	}
}
