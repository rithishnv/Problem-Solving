class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int a[] = new int[] { 0, 0 };
        int c = 0, max = 0;
        int[][] p = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Set<String> h = new HashSet<>();
        for (int[] i : obstacles)
            h.add(i[0] + "," + i[1]);
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                c = (c + 1) % 4;
            }
            if (commands[i] == -2) {
                c = (c + 3) % 4;
            }
            for (int k = 0; k < commands[i]; k++) {
                int x = p[c][0] + a[0];
                int y = p[c][1] + a[1];
                if (!h.contains(x + "," + y)) {
                    a[0] = x;
                    a[1] = y;
                    max = Math.max(max, a[0] * a[0] + a[1] * a[1]);
                } else
                    break;
            }
        }
        return max;
    }
}