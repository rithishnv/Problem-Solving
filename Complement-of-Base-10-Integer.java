1class Solution {
2    public int bitwiseComplement(int n) {
3        StringBuilder sb=new StringBuilder();
4        for(char i:(Integer.toBinaryString(n)).toCharArray()){
5            if(i=='1')
6            sb.append('0');
7            else
8            sb.append('1');
9        }
10        return Integer.parseInt(sb.toString(),2);
11    }
12}