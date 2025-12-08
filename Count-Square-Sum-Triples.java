1class Solution {
2    public int countTriples(int n) {
3        int cnt=0;
4        for(int i=1;i<=n;i++){
5            for(int j=1;j<=n;j++){
6                int s=(i*i)+(j*j);
7                int sq=(int)Math.sqrt(s);
8                if(sq*sq==s && sq<=n){
9                    cnt++;
10                }
11            }
12        }
13        return cnt;
14    }
15}