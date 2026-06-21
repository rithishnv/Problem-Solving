1class Solution {
2    public int maxIceCream(int[] costs, int coins) {
3        int[] a=new int[100001];
4        for(int i:costs){
5            a[i]++;
6        }
7        int n=0;
8        for(int i=1;i<100001;i++){
9            if(coins<=0)
10            break;
11            while(a[i]-->0&&coins>=i){
12            n++;
13            coins-=i;
14            }
15        }
16        return n;
17    }
18}