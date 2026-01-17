1class Solution {
2    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
3    int n = bottomLeft.length, ans = 0;
4
5	for(int i=0; i<n; i++){
6		for(int j=i+1; j<n; j++){
7			int[] startpoint = new int[2];
8			startpoint[0] = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
9			startpoint[1] = Math.max(bottomLeft[i][1], bottomLeft[j][1]);
10
11			int[] endpoint = new int[2];
12			endpoint[0] = Math.min(topRight[i][0], topRight[j][0]);
13			endpoint[1] = Math.min(topRight[i][1], topRight[j][1]);
14
15			if(endpoint[0] > startpoint[0] && endpoint[1] > startpoint[1]) {
16				int diff1 = endpoint[0]-startpoint[0];
17				int diff2 = endpoint[1]-startpoint[1];
18
19				int min = Math.min(diff1 , diff2);
20				ans = Math.max(min, ans);
21			}
22
23		}
24	}
25
26	return ans*1l*ans;
27    }
28}