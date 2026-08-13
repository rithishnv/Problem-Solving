class Solution {

    class Node {
        char leftChar, rightChar;
        int prefix, suffix, best, len;
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {
            update(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].best;
        }

        return ans;
    }

    private void build(int node, int l, int r) {
        tree[node] = new Node();

        if (l == r) {
            tree[node].leftChar = arr[l];
            tree[node].rightChar = arr[l];
            tree[node].prefix = 1;
            tree[node].suffix = 1;
            tree[node].best = 1;
            tree[node].len = 1;
            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        pull(node);
    }

    private void update(int node, int l, int r, int idx, char c) {
        if (l == r) {
            arr[idx] = c;
            tree[node].leftChar = c;
            tree[node].rightChar = c;
            tree[node].prefix = 1;
            tree[node].suffix = 1;
            tree[node].best = 1;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid)
            update(node * 2, l, mid, idx, c);
        else
            update(node * 2 + 1, mid + 1, r, idx, c);

        pull(node);
    }

    private void pull(int node) {
        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];
        Node cur = tree[node];

        cur.len = left.len + right.len;
        cur.leftChar = left.leftChar;
        cur.rightChar = right.rightChar;

        cur.prefix = left.prefix;
        if (left.prefix == left.len && left.rightChar == right.leftChar)
            cur.prefix += right.prefix;

        cur.suffix = right.suffix;
        if (right.suffix == right.len && left.rightChar == right.leftChar)
            cur.suffix += left.suffix;

        cur.best = Math.max(left.best, right.best);

        if (left.rightChar == right.leftChar)
            cur.best = Math.max(cur.best, left.suffix + right.prefix);
    }
}