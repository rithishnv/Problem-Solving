1class Solution {
2    public char[][] rotateTheBox(char[][] box) {
3        int m=box.length;
4        int n=box[0].length;
5        char[][] r=new char[n][m];
6        for (int i = 0; i < n; i++) { Arrays.fill(r[i], '.'); }
7       for (int i = 0; i < m; i++) {
8    int b = n - 1;
9    for (int j = n - 1; j >= 0; j--) {
10        if (box[i][j] == '*') {
11            r[j][m - 1 - i] = '*';
12            b = j - 1;
13        } else if (box[i][j] == '#') {
14            r[b][m - 1 - i] = '#';
15            b--;
16        }
17    }
18}
19
20        return r;
21    }
22}