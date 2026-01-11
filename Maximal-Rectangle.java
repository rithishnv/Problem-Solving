1class Solution {
2    public int maximalRectangle(char[][] matrix) {
3         if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
4            return 0;
5
6        int rows = matrix.length;
7        int cols = matrix[0].length;
8        int[] heights = new int[cols + 1];
9        int maxArea = 0;
10
11        for (char[] row : matrix) {
12            for (int i = 0; i < cols; i++) {
13                heights[i] = (row[i] == '1') ? heights[i] + 1 : 0;
14            }
15
16            Stack<Integer> stack = new Stack<>();
17            for (int i = 0; i < heights.length; i++) {
18                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
19                    int h = heights[stack.pop()];
20                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
21                    maxArea = Math.max(maxArea, h * w);
22                }
23                stack.push(i);
24            }
25        }
26
27        return maxArea;
28    }
29}