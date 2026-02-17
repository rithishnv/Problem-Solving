1class Solution {
2       public List<String> readBinaryWatch(int num) {
3        ArrayList<String> result = new ArrayList<>();
4        if(num>8)
5        return result;
6        for (int i = 0; i < 12; i++) {
7            for (int j = 0; j < 60; j++) {
8                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
9                    result.add(i + ":" +(j < 10 ? "0" + j : j));
10                }
11            }
12        }
13        return result;
14    }
15}