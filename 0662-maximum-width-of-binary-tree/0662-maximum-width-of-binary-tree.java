class Solution {

    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        int maxWidth = 0;

        while(!q.isEmpty()) {

            int size = q.size();

            long first = q.peek().index;
            long last = 0;

            for(int i = 0; i < size; i++) {

                Pair p = q.poll();

                TreeNode curr = p.node;
                long idx = p.index - first;

                last = p.index;

                if(curr.left != null) {
                    q.add(new Pair(curr.left, 2 * idx + 1));
                }

                if(curr.right != null) {
                    q.add(new Pair(curr.right, 2 * idx + 2));
                }
            }

            maxWidth = Math.max(maxWidth, (int)(last - first + 1));
        }

        return maxWidth;
    }
}