1class Solution {
2    public int countCollisions(String directions) {
3    int right = 0, res = 0;
4    boolean obstacle = false;
5    for (char d : directions.toCharArray())
6        if (d == 'R')
7            ++right;
8        else if (d == 'S') {
9            res += right;
10            right = 0;
11            obstacle = true;
12        }
13        else {
14            if (right > 0) {
15                res += right + 1;
16                right = 0;
17                obstacle = true;
18            }
19            else if (obstacle)
20                ++res;
21        }
22    return res;
23    }
24}