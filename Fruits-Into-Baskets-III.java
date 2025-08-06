class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        List<Integer> li=new ArrayList<>();
        int n=baskets.length;
        int set=(int)Math.sqrt(n);
        int cnt=0;
        int max=baskets[0];
        for(int i=0;i<n;i++){
            if(cnt==set){
                li.add(max);
                max=baskets[i];
                cnt=1;
            }
            else{
                max=Math.max(baskets[i],max);
                cnt++;
            }
        }
        li.add(max);
        cnt=0;
        for(int i=0;i<fruits.length;i++){
            int k=0,flag=1;
            for(int j=0;j<n;j+=set){
                if(li.get(k)<fruits[i]){
                    k++;
                    continue;
                }
                // max=li.get(k);
                for(int a=j;a<Math.min(j+set,n);a++){
                    if(baskets[a]>=fruits[i]){
                        flag=0;
                        baskets[a]=0;
                        break;
                    }
                }
               max=0;
               for(int a=j;a<Math.min(j+set,n);a++){
                max=Math.max(max,baskets[a]);
               }
               li.set(k,max);
               break;
                }
            cnt+=flag;
        }
        return cnt;
    }
}