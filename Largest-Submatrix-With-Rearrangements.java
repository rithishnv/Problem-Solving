1class Solution {
2    public int largestSubmatrix(int[][] matrix) {
3        int m = matrix.length, n = matrix[0].length;
4        int max_area = 0;
5        for (int i = 0; i < m; i++) {
6        	for (int j = 0; j < n; j++) {
7        		if (matrix[i][j] == 1 && i > 0) {
8        			matrix[i][j] = matrix[i - 1][j] + 1;
9        		}
10        	} 
11        	int[] heights = matrix[i].clone();
12        	Arrays.sort(heights);
13        	for (int j = n - 1; j >= 0; j--) {
14        		if (heights[j] == 0) break;
15        		int width = n - j;
16        		int height = heights[j];
17        		max_area = Math.max(max_area, width * height);
18        	}
19        }
20       return max_area;
21    }
22}